package com.barbearia.dfael.service;

import com.barbearia.dfael.domain.Barbeiro;
import com.barbearia.dfael.domain.dto.BarbeiroDTO;
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
    public void delete (String id){
        repo.deleteById(id);
    }

    public Barbeiro update(Barbeiro obj){
        Barbeiro newObj = findByid(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }
    private void updateData(Barbeiro newObj, Barbeiro obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
        newObj.setEspecialidades(obj.getEspecialidades());

    }

    public Barbeiro fromDTO(BarbeiroDTO objDto){
        return new Barbeiro (objDto.getId(), objDto.getName(), objDto.getEmail(), objDto.getEspecialidades());
    }
}
