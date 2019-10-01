package br.com.lcmleao.desafiopan.providers.impl;

import br.com.lcmleao.desafiopan.models.AddressModel;
import br.com.lcmleao.desafiopan.providers.AddressProvider;
import br.com.lcmleao.desafiopan.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoteAddressProvider implements AddressProvider {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${cep.service.url}")
    private String urlProvider;

    @Override
    public List<AddressModel> queryAddressByCEP(String cep) {
        ResponseEntity<AddressModel> found;
        found = restTemplate.getForEntity(
                String.format(urlProvider, cep),
                AddressModel.class
        );
        if ( found.getStatusCode().isError() ) {
            throw new RuntimeException(found.getStatusCode().getReasonPhrase());
        }
        return Arrays.asList(found.getBody()).stream().filter(
                (x) -> x != null && x.getMCep() != null
        ).collect(Collectors.toList());
    }
}
