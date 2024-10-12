package com.barbearia.dfael.domain;

import com.barbearia.dfael.domain.enums.StatusAgendamento;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class HistoricoAgendamento implements Serializable {
    private Long idHistorico;
    private Date dataHora;
    private StatusAgendamento status;
    private Barbeiro barbeiro;
    private Servico servico;
    private Usuario cliente;

    public HistoricoAgendamento(){

    }

    public HistoricoAgendamento(Long idHistorico, Date dataHora, StatusAgendamento status, Barbeiro barbeiro, Servico servico, Usuario cliente) {
        this.idHistorico = idHistorico;
        this.dataHora = dataHora;
        this.status = status;
        this.barbeiro = barbeiro;
        this.servico = servico;
        this.cliente = cliente;
    }

    public Long getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Long idHistorico) {
        this.idHistorico = idHistorico;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoAgendamento that = (HistoricoAgendamento) o;
        return Objects.equals(idHistorico, that.idHistorico);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idHistorico);
    }
}
