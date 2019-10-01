package br.com.lcmleao.desafiopan.services.impl;

import br.com.lcmleao.desafiopan.entities.State;
import br.com.lcmleao.desafiopan.helpers.Model2EntityHelper;
import br.com.lcmleao.desafiopan.presenters.StateVO;
import br.com.lcmleao.desafiopan.providers.StateProvider;
import br.com.lcmleao.desafiopan.repositories.StateRepository;
import br.com.lcmleao.desafiopan.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateProvider stateProvider;

    @Autowired
    private StateRepository stateRepository;

    @Transactional
    @Override
    public List<StateVO> queryStates(Comparator<State> sorter) {
        List<State> states;

        if ( stateRepository.count() == 0  ) {
            states = stateProvider.queryStates().stream().map(
                    Model2EntityHelper::toEntity
            ).
            collect(Collectors.toList());
            states = stateRepository.saveAll(states);
        } else {
            states = stateRepository.findAll();
        }

        if ( null != sorter ) {
            states.sort(sorter);
        }
        return states.stream().map(StateVO::toVo).collect(Collectors.toList());
    }

    @Override
    public List<StateVO> queryStates() {
        return queryStates((a, b) -> {
            if ( a.getSigla().equalsIgnoreCase("SP") ) {
                return -999;
            }
            if ( a.getSigla().equalsIgnoreCase("RJ") ) {
                return -998;
            }
            return a.getSigla().compareTo(b.getSigla());
        });
    }
}
