package br.com.lcmleao.desafiopan.presenters;

import br.com.lcmleao.desafiopan.entities.Address;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class AddressVO {
    private BigInteger id;
    private CityVO city;
    private StateVO state;
    private String zipCode;
    private String address;
    private String neighborhood;

    public static AddressVO toVO(Address address) {
        return AddressVO.builder().
               id(address.getId()).
               state( StateVO.toVo(address.getState()) ).
               city( CityVO.toVo(address.getCity()) ).
               zipCode( address.getZipCode() ).
               address( address.getAddress() ).
               neighborhood( address.getNeighborhood() ).
               build();
    }
}
