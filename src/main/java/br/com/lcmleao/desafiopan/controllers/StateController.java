package br.com.lcmleao.desafiopan.controllers;

import br.com.lcmleao.desafiopan.entities.State;
import br.com.lcmleao.desafiopan.presenters.StateVO;
import br.com.lcmleao.desafiopan.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {
    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity<List<StateVO>> list() {
        return ResponseEntity.ok().body(stateService.queryStates());

    }

}
