package br.com.lcmleao.desafiopan.providers;

import br.com.lcmleao.desafiopan.models.StateModel;

import java.util.List;
import java.util.Optional;

public interface StateProvider {
    public List<StateModel> queryStates();
    public Optional<StateModel> queryState(String sigla);
}
