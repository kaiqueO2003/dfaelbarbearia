package com.barbearia.dfael.service;

import com.barbearia.dfael.domain.Usuario;
import com.barbearia.dfael.domain.dto.UsuarioDTO;
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
    public void delete (String id){
        repo.deleteById(id);
    }

    public Usuario update(Usuario obj){
        Usuario newObj = findByid(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(Usuario newObj, Usuario obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
        newObj.setEmail(obj.getEmail());
    }

    public Usuario fromDTO(UsuarioDTO objDto){
        return new Usuario (objDto.getId(), objDto.getName(), objDto.getEmail());
    }


}
