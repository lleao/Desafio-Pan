package br.com.lcmleao.desafiopan.controllers;

import br.com.lcmleao.desafiopan.entities.State;
import br.com.lcmleao.desafiopan.helpers.Model2EntityHelper;
import br.com.lcmleao.desafiopan.presenters.CityVO;
import br.com.lcmleao.desafiopan.presenters.StateVO;
import br.com.lcmleao.desafiopan.services.CityService;
import br.com.lcmleao.desafiopan.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;
    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity<List<CityVO>> list() {
        return ResponseEntity.ok(cityService.queryAll());
    }

    @GetMapping("/by-state/{state}")
    public ResponseEntity<List<CityVO>> get(@PathVariable("state") String param) {
        final List<StateVO> states = stateService.queryStates();
        Optional<StateVO> state = states.stream().filter(
                (each) -> each.getSigla().equalsIgnoreCase(param)
        ).findFirst();
        return state.isPresent() ?
                ResponseEntity.ok(cityService.queryCityByStateId(state.get().getId())) :
                ResponseEntity.notFound().build();
    }
}
