package br.com.lcmleao.desafiopan.services;

import br.com.lcmleao.desafiopan.entities.State;
import br.com.lcmleao.desafiopan.presenters.StateVO;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface StateService {
    default Optional<StateVO> queryState(String state) {
        return queryStates().stream().filter(
                (each) -> each.getSigla().equalsIgnoreCase(state)
        ).findFirst();
    }
    List<StateVO> queryStates(Comparator<State> sorter);
    List<StateVO> queryStates();
}
