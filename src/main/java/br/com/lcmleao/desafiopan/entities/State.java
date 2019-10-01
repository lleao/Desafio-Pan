package br.com.lcmleao.desafiopan.entities;


import br.com.lcmleao.desafiopan.presenters.StateVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "UF")
@Data
public class State {
    @Id
    private BigInteger id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sigla")
    private String sigla;

    public static State toEntity(StateVO state) {
        return State.builder().
                id( state.getId() ).
                nome( state.getNome() ).
                sigla( state.getSigla() ).
                build();
    }
}
