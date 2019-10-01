package br.com.lcmleao.desafiopan;

import br.com.lcmleao.desafiopan.entities.State;
import br.com.lcmleao.desafiopan.presenters.CityVO;
import br.com.lcmleao.desafiopan.presenters.StateVO;
import br.com.lcmleao.desafiopan.services.CityService;
import br.com.lcmleao.desafiopan.services.StateService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
@DisplayName("Desafio PAN - StateService teste")
public class CityServiceTest {

    @Autowired
    private StateService stateService;

    @Autowired
    private CityService cityService;

    @Test
    @DisplayName("Verifica se todas as UFs foram carregadas")
    public void queryCityBrasilia() {
        Optional<StateVO> df = stateService.queryState("DF");

        Mockito.when(cityService.queryCityByStateId(df.get().getId())).thenReturn(
                Arrays.asList(
                    CityVO.builder().
                    id(new BigInteger("42")).
                    state( df.get() ).
                    name("Brasília").
                    build()
                )
        );

        List<CityVO> cities = cityService.queryCityByStateId(df.get().getId());
        assertEquals(1, cities.size());
        assertEquals("Brasília", cities.get(0).getName());
    }


}
