package br.com.lcmleao.desafiopan.services.impl;

import br.com.lcmleao.desafiopan.entities.Address;
import br.com.lcmleao.desafiopan.entities.Client;
import br.com.lcmleao.desafiopan.entities.ClientAddress;
import br.com.lcmleao.desafiopan.helpers.CEP;
import br.com.lcmleao.desafiopan.presenters.ClientAddressVO;
import br.com.lcmleao.desafiopan.presenters.ClientVO;
import br.com.lcmleao.desafiopan.repositories.AddressRepository;
import br.com.lcmleao.desafiopan.repositories.ClientRepository;
import br.com.lcmleao.desafiopan.services.AddressService;
import br.com.lcmleao.desafiopan.services.CityService;
import br.com.lcmleao.desafiopan.services.ClientService;
import br.com.lcmleao.desafiopan.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private StateService stateService;

    @Autowired
    private CityService cityService;

    @Override
    public Optional<ClientVO> queryByID(BigInteger id) {
        Optional<Client> model = clientRepository.findById(id);
        return model.isPresent() ? Optional.of(ClientVO.toVo(model.get())) : Optional.empty();
    }

    @Override
    public Optional<ClientVO> queryByCPF(String cpf) {
        Optional<Client> model = clientRepository.queryByCPF(cpf);
        return model.isPresent() ? Optional.of(ClientVO.toVo(model.get())) : Optional.empty();
    }

    @Override
    public List<ClientVO> queryAll() {
        return clientRepository.findAll().stream().map(ClientVO::toVo).collect(Collectors.toList());
    }

    @Override
    public Optional<ClientVO> saveClient(Client c) {
        List<ClientAddress> clintAddrs = c.getAddresses();

        normalizeAddress(clintAddrs);

        return Optional.of(ClientVO.toVo( clientRepository.save(c) ));
    }

    private void normalizeAddress(List<ClientAddress> clintAddrs) {
        clintAddrs.stream().forEach( (each) -> {
            Optional<Address> naddr;
            if ( null != each.getAddress().getId() ) {
                naddr = addressRepository.findById(each.getAddress().getId());
            } else {
                naddr =  addressRepository.findAllByCep(CEP.withHifen( each.getAddress().getZipCode())).stream().findFirst();
                if ( !naddr.isPresent() ) {
                    addressService.findByCEP(CEP.withHifen(each.getAddress().getZipCode()));
                    naddr =  addressRepository.findAllByCep(CEP.withHifen(each.getAddress().getZipCode())).stream().findFirst();
                }
            }
            if ( naddr.isPresent() ) {
                each.setAddress( naddr.get() );
            }
        } );
    }

    @Override
    public Optional<ClientVO> updateClient(Client c) {
        return Optional.empty();
    }

    @Override
    public Optional<ClientVO> updateClientAddress(BigInteger id, ClientAddress cAddr) {
        Optional<Client> client = clientRepository.findById(id);
        if ( !client.isPresent() ) {
            return null;
        }
        List<ClientAddress> addrs = Arrays.asList(cAddr);
        normalizeAddress(addrs);
        client.get().setAddresses(addrs);
        return Optional.of(ClientVO.toVo( clientRepository.save(client.get()) ));
    }
}
