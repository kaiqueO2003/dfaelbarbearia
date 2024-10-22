package com.barbearia.dfael.controller;


import com.barbearia.dfael.domain.Agendamento;
import com.barbearia.dfael.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoController {

    @Autowired
    AgendamentoService service;

    @GetMapping
    public ResponseEntity<List<Agendamento>> findAll(){
        List<Agendamento> list= service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Agendamento> findById(@PathVariable String id){
        Agendamento obj = service.findByid(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Agendamento> insert(@RequestBody Agendamento obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
}
