package br.com.lcmleao.desafiopan.services;

import br.com.lcmleao.desafiopan.entities.Address;
import br.com.lcmleao.desafiopan.presenters.AddressVO;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<AddressVO> findByCEP(String cep);
    List<AddressVO> findAll();
    Optional<AddressVO> findById(BigInteger id);
}
