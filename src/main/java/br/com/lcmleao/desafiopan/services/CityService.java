package br.com.lcmleao.desafiopan.services;

import br.com.lcmleao.desafiopan.entities.City;
import br.com.lcmleao.desafiopan.entities.State;
import br.com.lcmleao.desafiopan.presenters.CityVO;

import java.math.BigInteger;
import java.util.List;

public interface CityService {
    List<CityVO> queryAll();
    List<CityVO> queryCityByStateId(BigInteger stateId);
    List<CityVO> queryCityByState(State state);
    List<CityVO> queryCityByStateAndNameLike(State state, String likely);
    List<CityVO> queryCityByStateIdAndNameLike(BigInteger stateId, String likely);
}
