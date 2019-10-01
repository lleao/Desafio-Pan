package br.com.lcmleao.desafiopan.providers;

import br.com.lcmleao.desafiopan.models.AddressModel;

import java.util.List;

public interface AddressProvider {
    public List<AddressModel> queryAddressByCEP(String cep);
}
