package br.com.lcmleao.desafiopan.presenters;

import br.com.lcmleao.desafiopan.entities.City;
import br.com.lcmleao.desafiopan.entities.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Builder
@Data
public class CityVO {
    private BigInteger id;
    private StateVO state;
    private String name;

    public static CityVO toVo(City city) {
        return CityVO.builder().
                id(city.getId()).
                state( StateVO.toVo(city.getState()) ).
                name( city.getName() ).
                build();
    }
}
