package com.barbearia.dfael.service;

import com.barbearia.dfael.domain.Barbeiro;
import com.barbearia.dfael.domain.Usuario;
import com.barbearia.dfael.repository.BarbeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarbeiroService {
    @Autowired
    BarbeiroRepository repo;

    public List<Barbeiro> findAll(){
        return repo.findAll();
    }
    public Barbeiro findByid(String id){
        Optional<Barbeiro> obj = repo.findById(id);
        return obj.get();
    }
}
