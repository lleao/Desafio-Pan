package br.com.lcmleao.desafiopan.presenters;


import br.com.lcmleao.desafiopan.entities.Client;
import br.com.lcmleao.desafiopan.entities.ClientAddress;
import br.com.lcmleao.desafiopan.entities.State;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class ClientVO {
    private BigInteger id;
    private String name;
    private List<ClientAddressVO> enderecos;

    public static ClientVO toVo(Client client) {
        return ClientVO.builder().
                id(client.getId()).
                name(client.getName()).
                enderecos( client.getAddresses().stream().map(ClientAddressVO::toVo).collect(Collectors.toList()) ).
                build();
    }
}
