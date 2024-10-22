package com.barbearia.dfael.domain;

import com.barbearia.dfael.domain.enums.StatusAgendamento;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
@Entity
public class HistoricoAgendamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorico;
    private Date dataHora;
    private StatusAgendamento status;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "barbeiro_id")
    private Barbeiro barbeiro;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;





    public HistoricoAgendamento(){

    }

    public HistoricoAgendamento(Long idHistorico, Date dataHora, StatusAgendamento status, Barbeiro barbeiro, Servico servico, Usuario usuario) {
        this.idHistorico = idHistorico;
        this.dataHora = dataHora;
        this.status = status;
        this.barbeiro = barbeiro;
        this.servico = servico;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setCliente(Usuario usuario) {
        this.usuario = usuario;
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
