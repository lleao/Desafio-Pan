package br.com.lcmleao.desafiopan.parameters;

import br.com.lcmleao.desafiopan.entities.Address;
import br.com.lcmleao.desafiopan.entities.City;
import br.com.lcmleao.desafiopan.entities.ClientAddress;
import br.com.lcmleao.desafiopan.entities.State;
import lombok.Data;

@Data
public class AddressParameter {
    private String address;
    private String number;
    private String city;
    private String neighborhood;
    private String zipCode;
    private String complement;
    private String uf;
    public ClientAddress toEntity() {
        State st = State.builder().sigla(uf).build();
        return ClientAddress.builder().
                id(null).
                address(
                        Address.builder().
                        id(null).
                        city(
                                City.builder()
                                        .name(city)
                                        .state(st)
                                        .build()
                        ).
                        address(address).
                        neighborhood(neighborhood).
                        zipCode(zipCode).
                        state(st).
                        build()
                ).
                number(number).
                complement(complement).
                build();
    }
}
