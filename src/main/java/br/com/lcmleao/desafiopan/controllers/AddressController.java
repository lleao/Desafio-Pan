package br.com.lcmleao.desafiopan.controllers;

import br.com.lcmleao.desafiopan.entities.Address;
import br.com.lcmleao.desafiopan.presenters.AddressVO;
import br.com.lcmleao.desafiopan.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressVO>> list() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressVO> get(@PathVariable("id") String id) {
        Optional<AddressVO> ret = addressService.findById(new BigInteger(id));
        return ret.isPresent() ? ResponseEntity.ok(ret.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping("cep/{cep}")
    public ResponseEntity<List<AddressVO>> getByCep(@PathVariable("cep") String cep) {
        return ResponseEntity.ok( addressService.findByCEP(cep) );
    }
}
