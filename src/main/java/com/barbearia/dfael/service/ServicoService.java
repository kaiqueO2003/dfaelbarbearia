package com.barbearia.dfael.service;

import com.barbearia.dfael.domain.Agendamento;
import com.barbearia.dfael.domain.Servico;
import com.barbearia.dfael.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
    @Autowired
    ServicoRepository repo;

    public Servico insert(Servico obj){
        return repo.save(obj);
    }

    public List<Servico> findAll(){
        return repo.findAll();
    }
    public Servico findByid(Long id){
        Optional<Servico> obj = repo.findById(id);
        return obj.get();
    }
}
