package com.barbearia.dfael.controller;

import com.barbearia.dfael.domain.Barbeiro;
import com.barbearia.dfael.domain.Usuario;
import com.barbearia.dfael.domain.dto.BarbeiroDTO;
import com.barbearia.dfael.domain.dto.UsuarioDTO;
import com.barbearia.dfael.service.BarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody BarbeiroDTO objDto, @PathVariable String id){
        Barbeiro obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

}
