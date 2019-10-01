package br.com.lcmleao.desafiopan.presenters;

import br.com.lcmleao.desafiopan.entities.ClientAddress;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class ClientAddressVO {
    private BigInteger id;
    private AddressVO address;
    private String number;
    private String complement;

    public static ClientAddressVO toVo(ClientAddress addr) {
        return ClientAddressVO.builder().
                id(addr.getId()).
                complement(addr.getComplement()).
                number(addr.getNumber()).
                address(
                        AddressVO.toVO(addr.getAddress())
                ).
                build();

    }
}
