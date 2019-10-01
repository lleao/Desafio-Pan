package br.com.lcmleao.desafiopan;

import br.com.lcmleao.desafiopan.presenters.StateVO;
import br.com.lcmleao.desafiopan.services.StateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
@DisplayName("Desafio PAN - StateService teste")
public class StateServiceTest {

    @Autowired
    private StateService stateService;

    @Test
    @DisplayName("Verifica se todas as UFs foram carregadas")
    public void queryStates() {
        List<StateVO> states = stateService.queryStates();
        assertEquals(27, states.size());
    }

    @Test
    @DisplayName("Verifica se todas as UFs foram carregadas")
    public void queryDF() {
        List<StateVO> states = stateService.queryStates();

        Optional<StateVO> df = states.stream().filter((state) -> state.getSigla().equalsIgnoreCase("DF")).findFirst();
        assertTrue(df.isPresent());
        assertEquals("DF", df.get().getSigla());
    }

}
