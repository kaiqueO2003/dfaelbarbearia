package com.barbearia.dfael.domain.dto;

import com.barbearia.dfael.domain.Barbeiro;
import com.barbearia.dfael.domain.Servico;

public class ServicoDTO {
    private Long idServico;
    private String nomeServico;
    private Integer duracao;
    private Double preco;

    public ServicoDTO(Servico obj) {
        idServico = obj.getIdServico();
        nomeServico = obj.getNomeServico();
        duracao = obj.getDuracao();
        preco = obj.getPreco();
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
}
