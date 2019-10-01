package br.com.lcmleao.desafiopan.parameters;

import br.com.lcmleao.desafiopan.entities.Client;
import lombok.Data;

import java.math.BigInteger;
import java.util.Arrays;

@Data
public class ClientParameter {
    private BigInteger id;
    private String name;
    private String cpf;
    private AddressParameter address;

    public Client toEntity() {
        return Client.builder().
               id(null).
               name(name).
               cpf( cpf ).
               addresses(
                       Arrays.asList(
                               address.toEntity()
                       )
               ).
               build();
    }
}
