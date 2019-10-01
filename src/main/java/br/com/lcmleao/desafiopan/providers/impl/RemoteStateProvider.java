package br.com.lcmleao.desafiopan.providers.impl;

import br.com.lcmleao.desafiopan.models.AddressModel;
import br.com.lcmleao.desafiopan.models.StateModel;
import br.com.lcmleao.desafiopan.providers.AddressProvider;
import br.com.lcmleao.desafiopan.providers.StateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RemoteStateProvider implements StateProvider {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${state.service.url}")
    private String urlProvider;

    @Override
    public Optional<StateModel> queryState(String sigla) {
        return queryStates().stream().filter(
                (state) -> state.getMSigla().equalsIgnoreCase(sigla)
        ).findFirst();
    }

    @Override
    public List<StateModel> queryStates() {
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        ResponseEntity<? extends StateModel[]> result = restTemplate.getForEntity(urlProvider, new StateModel[0].getClass());

        return Arrays.asList(result.getBody());
    }
}
