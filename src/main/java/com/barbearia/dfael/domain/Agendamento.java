package com.barbearia.dfael.domain;

import com.barbearia.dfael.domain.enums.StatusAgendamento;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name ="agendamentos")
public class Agendamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgendamento;
    private Date hora;
    private StatusAgendamento status;

    public Agendamento(){

    }
    public Agendamento(Long idAgendamento, Date hora, StatusAgendamento status) {
        this.idAgendamento = idAgendamento;
        this.hora = hora;
        this.status = status;
    }

    public Long getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Long idAgendamento) {
        this.idAgendamento = idAgendamento;
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
