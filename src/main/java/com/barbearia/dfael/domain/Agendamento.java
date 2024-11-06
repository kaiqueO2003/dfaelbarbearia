package com.barbearia.dfael.domain;

import com.barbearia.dfael.domain.enums.StatusAgendamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "agendamentos")
public class Agendamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgendamento;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date hora;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
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

    public Agendamento(){

    }

    public Agendamento(Long idAgendamento, Date hora, StatusAgendamento status) {
        this.idAgendamento = idAgendamento;
        this.hora = hora;
        this.status = status;
    }

    public Agendamento(Long idAgendamento, Usuario usuario, Barbeiro barbeiro, Servico servico, Date hora, StatusAgendamento status) {
        this.idAgendamento = idAgendamento;
        this.usuario = usuario;
        this.barbeiro = barbeiro;
        this.servico = servico;
        this.hora = hora;
        this.status = status;
    }


    public Long getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Long idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(idAgendamento, that.idAgendamento);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idAgendamento);
    }
}
