package br.com.lcmleao.desafiopan.controllers;

import br.com.lcmleao.desafiopan.parameters.AddressParameter;
import br.com.lcmleao.desafiopan.parameters.ClientParameter;
import br.com.lcmleao.desafiopan.presenters.ClientVO;
import br.com.lcmleao.desafiopan.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Object> list() {
        return ResponseEntity.ok(clientService.queryAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") String id) {
        Optional<ClientVO> c = clientService.queryByID(new BigInteger(id));
        return c.isPresent() ? ResponseEntity.ok(c.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping("/by-cpf/{cpf}")
    public ResponseEntity<Object> getByCPF(@PathVariable("cpf") String cpf) {
        Optional<ClientVO> c = clientService.queryByCPF(cpf);
        return c.isPresent() ? ResponseEntity.ok(c.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ClientVO> create(@RequestBody ClientParameter newClient) {
        Optional<ClientVO> c = clientService.saveClient(newClient.toEntity());
        return c.isPresent() ? ResponseEntity.status(HttpStatus.CREATED).body(c.get()) : ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<ClientVO> update(@RequestBody ClientParameter newClient) {
        Optional<ClientVO> c = clientService.updateClient(newClient.toEntity());
        return c.isPresent() ? ResponseEntity.ok(c.get()) : ResponseEntity.notFound().build();
    }

    @PutMapping("address/{id}")
    public ResponseEntity<ClientVO> updateAddress(@PathVariable("id") String id, @RequestBody AddressParameter newClient) {
        Optional<ClientVO> c = clientService.updateClientAddress(new BigInteger(id), newClient.toEntity());
        return c.isPresent() ? ResponseEntity.ok(c.get()) : ResponseEntity.notFound().build();
    }
}
