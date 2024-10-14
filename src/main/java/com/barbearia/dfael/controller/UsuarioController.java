package com.barbearia.dfael.controller;

import com.barbearia.dfael.domain.Usuario;
import com.barbearia.dfael.domain.dto.UsuarioDTO;
import com.barbearia.dfael.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>>findAll(){
    List<Usuario> list = service.findAll();
        List<UsuarioDTO> listDto= list.stream().map(x-> new UsuarioDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO>findById(@PathVariable String id){
        Usuario obj = service.findByid(id);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

}
