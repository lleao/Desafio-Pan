package br.com.lcmleao.desafiopan.presenters;


import br.com.lcmleao.desafiopan.entities.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Builder
@Data
public class StateVO {
    private BigInteger id;
    private String nome;
    private String sigla;

    public static StateVO toVo(State state) {
        return StateVO.builder().
                id( state.getId() ).
                nome( state.getNome() ).
                sigla( state.getSigla() ).
                build();
    }
}
