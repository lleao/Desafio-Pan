package br.com.lcmleao.desafiopan.providers;

import br.com.lcmleao.desafiopan.entities.State;
import br.com.lcmleao.desafiopan.models.CityModel;
import br.com.lcmleao.desafiopan.models.StateModel;

import java.util.List;

public interface CityProvider {
    public List<CityModel> queryCities(State param);
    public List<CityModel> queryCitiesByStateId(String param);
}
