package br.com.lcmleao.desafiopan.helpers;

import br.com.lcmleao.desafiopan.entities.Address;
import br.com.lcmleao.desafiopan.entities.State;
import br.com.lcmleao.desafiopan.models.AddressModel;
import br.com.lcmleao.desafiopan.models.StateModel;

import java.math.BigInteger;
import java.util.Optional;

public class Model2EntityHelper {
    public static State toEntity(Optional<StateModel> model) {
        return model.isPresent() ? toEntity(model.get()) : null;
    }
    public static State toEntity(StateModel model) {
        return State.builder().
                id(BigInteger.valueOf(model.getMId())).
                sigla(model.getMSigla()).
                nome(model.getMNome()).
                build();
    }

    public static Address toEntity(AddressModel addressModel) {
        return Address.builder().
                address( addressModel.getMLogradouro() ).
                zipCode(addressModel.getMCep()).
                neighborhood(addressModel.getMBairro()).
                build();
    }
}
