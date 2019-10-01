package br.com.lcmleao.desafiopan;

import br.com.lcmleao.desafiopan.services.CityService;
import br.com.lcmleao.desafiopan.services.StateService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class ProductServiceTestConfiguration {
    @Bean
    @Primary
    public CityService cityService() {
        return Mockito.mock(CityService.class);
    }
}
