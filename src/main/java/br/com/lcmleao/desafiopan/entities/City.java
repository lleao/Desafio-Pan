package br.com.lcmleao.desafiopan.entities;

import br.com.lcmleao.desafiopan.presenters.CityVO;
import br.com.lcmleao.desafiopan.presenters.StateVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "CIDADE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {
    @Id
    @GeneratedValue
    private BigInteger id;
    @ManyToOne
    private State state;
    @Column(nullable = false)
    private String name;

    public static City toEntity(CityVO city) {
        return City.builder().
                id(city.getId()).
                state( State.toEntity(city.getState()) ).
                name( city.getName() ).
                build();
    }

}
