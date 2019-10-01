package br.com.lcmleao.desafiopan.services.impl;

import br.com.lcmleao.desafiopan.entities.Address;
import br.com.lcmleao.desafiopan.entities.City;
import br.com.lcmleao.desafiopan.entities.State;
import br.com.lcmleao.desafiopan.helpers.CEP;
import br.com.lcmleao.desafiopan.helpers.Model2EntityHelper;
import br.com.lcmleao.desafiopan.presenters.AddressVO;
import br.com.lcmleao.desafiopan.presenters.CityVO;
import br.com.lcmleao.desafiopan.presenters.StateVO;
import br.com.lcmleao.desafiopan.providers.AddressProvider;
import br.com.lcmleao.desafiopan.repositories.AddressRepository;
import br.com.lcmleao.desafiopan.services.AddressService;
import br.com.lcmleao.desafiopan.services.CityService;
import br.com.lcmleao.desafiopan.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    
    @Autowired
    private AddressRepository addrRepository;

    @Autowired
    private AddressProvider addressProvider;

    @Autowired
    private StateService stateService;

    @Autowired
    private CityService cityService;

    @Override
    @Transactional
    public List<AddressVO> findAll() {
        return addrRepository.findAll().stream().
               map(AddressVO::toVO).
               collect(Collectors.toList());
    }

    @Override
    public Optional<AddressVO> findById(BigInteger id) {
        Optional<Address> addr = addrRepository.findById(id);
        return addr.isPresent() ? Optional.of( AddressVO.toVO(addr.get())) : Optional.empty();
    }

    @Override
    public List<AddressVO> findByCEP(String cep) {
        List<Address> providedAddresses;
        cep = CEP.withHifen(cep);
        if ( addrRepository.existsByCEP(cep) ) {
            return addrRepository.findAllByCep(cep).stream().map(AddressVO::toVO).collect(Collectors.toList());
        }

        providedAddresses = addressProvider.
                queryAddressByCEP(cep).stream().map(
                    (each) -> {
                        Address entity = Model2EntityHelper.toEntity(each);
                        Optional<StateVO> uf;
                        Optional<CityVO> city;

                        uf = stateService.queryState(each.getMUf());

                        if ( uf.isPresent() ) {
                            city = cityService.queryCityByStateIdAndNameLike(
                                    uf.get().getId(),
                                    each.getMLocalidade()
                            ).stream().findFirst();
                            entity.setState(State.toEntity(uf.get()) );
                            if ( city.isPresent() ) {
                                entity.setCity(City.toEntity(city.get()));
                            }
                        }
                        return entity;
                    }
                ).
                collect(Collectors.toList());
        if ( !providedAddresses.isEmpty() ) {
            List<AddressVO> saved = addrRepository.saveAll(providedAddresses).stream().map(AddressVO::toVO).collect(Collectors.toList());
            addrRepository.flush();
            return saved;
        }

        return providedAddresses.stream().map(AddressVO::toVO).collect(Collectors.toList());
    }
}
