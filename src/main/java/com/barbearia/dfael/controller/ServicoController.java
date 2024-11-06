package com.barbearia.dfael.controller;

import com.barbearia.dfael.domain.Servico;
import com.barbearia.dfael.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {

    @Autowired
    ServicoService service;
    @GetMapping
    public ResponseEntity<List<Servico>> findAll(){
        List<Servico> list= service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Long id){
        Servico obj = service.findByid(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Servico> insert(@RequestBody Servico obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
}
