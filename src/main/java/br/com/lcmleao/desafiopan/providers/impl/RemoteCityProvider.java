package br.com.lcmleao.desafiopan.providers.impl;

import br.com.lcmleao.desafiopan.entities.State;
import br.com.lcmleao.desafiopan.models.CityModel;
import br.com.lcmleao.desafiopan.models.StateModel;
import br.com.lcmleao.desafiopan.providers.CityProvider;
import br.com.lcmleao.desafiopan.providers.StateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class RemoteCityProvider implements CityProvider {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${city.service.url}")
    private String urlProvider;

    @Override
    public List<CityModel> queryCitiesByStateId(String param) {

        ResponseEntity<? extends CityModel[]> result = restTemplate.getForEntity(
                String.format(urlProvider, param),
                new CityModel[0].getClass()
        );

        return Arrays.asList(result.getBody());
    }

    @Override
    public List<CityModel> queryCities(State param) {

        ResponseEntity<? extends CityModel[]> result = restTemplate.getForEntity(
            String.format(urlProvider, param.getId()),
            new CityModel[0].getClass()
        );

        return Arrays.asList(result.getBody());
    }
}
