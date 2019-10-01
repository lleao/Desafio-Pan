package br.com.lcmleao.desafiopan.config;

import br.com.lcmleao.desafiopan.providers.AddressProvider;
import br.com.lcmleao.desafiopan.providers.CityProvider;
import br.com.lcmleao.desafiopan.providers.StateProvider;
import br.com.lcmleao.desafiopan.providers.impl.RemoteAddressProvider;
import br.com.lcmleao.desafiopan.providers.impl.RemoteCityProvider;
import br.com.lcmleao.desafiopan.providers.impl.RemoteStateProvider;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
public class DesafioPanConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate template = builder.build();
        template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        return template;
    }

    @Bean
    public AddressProvider addressProvider() {
        return new RemoteAddressProvider();
    }

    @Bean
    public CityProvider cityProvider() {
        return new RemoteCityProvider();
    }

    @Bean
    public StateProvider stateProvider() {
        return new RemoteStateProvider();
    }
}
