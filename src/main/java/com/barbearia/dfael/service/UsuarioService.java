package com.barbearia.dfael.service;

import com.barbearia.dfael.domain.Usuario;
import com.barbearia.dfael.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    public List<Usuario> findAll(){
        return repo.findAll();
    }
    public Usuario findByid(String id){
        Optional<Usuario> obj = repo.findById(id);
        return obj.get();
    }

}
