package com.barbearia.dfael.domain;

import java.io.Serializable;
import java.util.Objects;

public class Servico implements Serializable {
    private Long idServico;
    private String nomeServico;
    private Integer duracao;
    private Double preco;

    public Servico(){

    }

    public Servico(Long idServico, String nomeServico, Integer duracao, Double preco) {
        this.idServico = idServico;
        this.nomeServico = nomeServico;
        this.duracao = duracao;
        this.preco = preco;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return Objects.equals(idServico, servico.idServico);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idServico);
    }
}
