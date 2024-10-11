package com.barbearia.dfael.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name ="barbeiros")
public class Barbeiro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBarbeiro;
    private String nome;
    private String especialidades;
    private String telefone;


    public Barbeiro(){

    }

    public Barbeiro(Long idBarbeiro, String nome, String especialidades, String telefone) {
        this.idBarbeiro = idBarbeiro;
        this.nome = nome;
        this.especialidades = especialidades;
        this.telefone = telefone;
    }

    public Long getIdBarbeiro() {
        return idBarbeiro;
    }

    public void setIdBarbeiro(Long idBarbeiro) {
        this.idBarbeiro = idBarbeiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barbeiro barbeiro = (Barbeiro) o;
        return Objects.equals(idBarbeiro, barbeiro.idBarbeiro);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idBarbeiro);
    }
}

