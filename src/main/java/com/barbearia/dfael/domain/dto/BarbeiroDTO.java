package com.barbearia.dfael.domain.dto;

import com.barbearia.dfael.domain.Barbeiro;
import com.barbearia.dfael.domain.Usuario;

import java.io.Serializable;

public class BarbeiroDTO implements Serializable {
    private String id;
    private String name;
    private String email;
    private String especialidades;
    private String disponibilidade;
    private Double avaliacaClientes;

    public BarbeiroDTO(){

    }

    public BarbeiroDTO(Barbeiro obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
        especialidades = obj.getEspecialidades();
        disponibilidade = obj.getDisponibilidade();
        avaliacaClientes = obj.getAvaliacaClientes();
    }

    public Barbeiro toEntity() {
        Barbeiro barbeiro = new Barbeiro();
        barbeiro.setId(this.id); // Verifique se `this.id` não é nulo
        barbeiro.setName(this.name); // Verifique se `this.name` não é nulo
        barbeiro.setEmail(this.email); // Verifique se `this.email` não é nulo
        barbeiro.setEspecialidades(this.especialidades); // Verifique se `this.especialidades` não é nulo
        barbeiro.setDisponibilidade(this.disponibilidade); // Verifique se `this.disponibilidade` não é nulo
        barbeiro.setAvaliacaClientes(this.avaliacaClientes); // Verifique se `this.avaliacaClientes` não é nulo
        return barbeiro;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Double getAvaliacaClientes() {
        return avaliacaClientes;
    }

    public void setAvaliacaClientes(Double avaliacaClientes) {
        this.avaliacaClientes = avaliacaClientes;
    }
}
