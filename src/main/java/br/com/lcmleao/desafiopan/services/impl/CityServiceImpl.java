package br.com.lcmleao.desafiopan.services.impl;

import br.com.lcmleao.desafiopan.entities.City;
import br.com.lcmleao.desafiopan.entities.State;
import br.com.lcmleao.desafiopan.helpers.Model2EntityHelper;
import br.com.lcmleao.desafiopan.presenters.CityVO;
import br.com.lcmleao.desafiopan.presenters.StateVO;
import br.com.lcmleao.desafiopan.providers.CityProvider;
import br.com.lcmleao.desafiopan.providers.StateProvider;
import br.com.lcmleao.desafiopan.repositories.CityRepository;
import br.com.lcmleao.desafiopan.repositories.StateRepository;
import br.com.lcmleao.desafiopan.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityProvider cityProvider;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<CityVO> queryCityByStateIdAndNameLike(BigInteger stateId, String likely) {
        Optional<State> state = stateRepository.findById(stateId);
        return state.isPresent() ? queryCityByStateAndNameLike(state.get(), likely) : Collections.emptyList();
    }

    @Override
    public List<CityVO> queryCityByStateAndNameLike(State state, String likely) {
        List<City> cities;
        cities = cityRepository.queryCitiesByState(state);

        if ( cities.isEmpty() ) {
            cities = cityProvider.queryCities(state).stream().
                    map(
                            (model) -> City.builder().
                                    id(BigInteger.valueOf(model.getMId())).
                                    name(model.getMNome()).
                                    state(state).
                                    build()
                    ).collect(Collectors.toList());
            cities = cityRepository.saveAll(cities);
            cities = cities.stream().filter(
                    (each) -> each.getName().toLowerCase().contains(likely.toLowerCase())
            ).collect(Collectors.toList());
        }

        return cities.stream().map(CityVO::toVo).collect(Collectors.toList());
    }

    @Override
    public List<CityVO> queryCityByStateId(BigInteger stateId) {
        Optional<State> state = stateRepository.findById(stateId);
        return state.isPresent() ? queryCityByState(state.get()) : Collections.emptyList();
    }

    @Override
    public List<CityVO> queryAll() {
        return cityRepository.findAll().stream().map(CityVO::toVo).collect(Collectors.toList());
    }

    @Override
    public List<CityVO> queryCityByState(State state) {
        return cityProvider.queryCities(state).stream().map(
                (model) -> CityVO.builder().
                        id( BigInteger.valueOf(model.getMId()) ).
                        name( model.getMNome() ).
                        state(StateVO.toVo(state)).
                        build()
        ).collect(Collectors.toList());
    }
}
