package com.barbearia.dfael.domain;

import com.barbearia.dfael.domain.enums.UsuarioRole;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "barbeiros")
public class Barbeiro extends Usuario implements Serializable {
    private String especialidades;
    private String disponibilidade;
    private Double avaliacaClientes;


    @OneToMany(mappedBy = "barbeiro")
    private List<Agendamento> agendamentos;


    public Barbeiro() {

    }

    public Barbeiro(String id, String name, String email, String password, String telefone, UsuarioRole role, String especialidades, String disponibilidade, Double avaliacaClientes) {
        super(id, name, email, password, telefone, role);
        this.especialidades = especialidades;
        this.disponibilidade = disponibilidade;
        this.avaliacaClientes = avaliacaClientes;
    }

    public Barbeiro(String id, String name, String email, String especialidades) {
        super(id, name, email);
        this.especialidades = especialidades;
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



