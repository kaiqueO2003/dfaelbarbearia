package com.barbearia.dfael.controller;

import com.barbearia.dfael.domain.Barbeiro;
import com.barbearia.dfael.domain.Usuario;
import com.barbearia.dfael.domain.dto.BarbeiroDTO;
import com.barbearia.dfael.domain.dto.UsuarioDTO;
import com.barbearia.dfael.service.BarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/barbeiros")
public class BarbeiroController {

    @Autowired
    BarbeiroService service;


    @GetMapping
    public ResponseEntity<List<BarbeiroDTO>>findAll(){
        List<Barbeiro> list = service.findAll();
        List<BarbeiroDTO> barbeiroDto= list.stream().map(x-> new BarbeiroDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(barbeiroDto);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<BarbeiroDTO>findById(@PathVariable String id){
        Barbeiro obj = service.findByid(id);
        return ResponseEntity.ok().body(new BarbeiroDTO(obj));
    }
}
