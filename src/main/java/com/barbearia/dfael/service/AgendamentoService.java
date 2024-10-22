package com.barbearia.dfael.service;

import com.barbearia.dfael.domain.Agendamento;
import com.barbearia.dfael.domain.Barbeiro;
import com.barbearia.dfael.repository.AgendamentoRepository;
import com.barbearia.dfael.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AgendamentoService {
    @Autowired
    AgendamentoRepository repo;


    public Agendamento insert(Agendamento obj){
        return repo.save(obj);
    }

    public List<Agendamento> findAll(){
        return repo.findAll();
    }
    public Agendamento findByid(String id){
        Optional<Agendamento> obj = repo.findById(id);
        return obj.get();
    }


}
