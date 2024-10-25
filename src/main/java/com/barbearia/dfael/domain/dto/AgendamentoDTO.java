package com.barbearia.dfael.domain.dto;

import com.barbearia.dfael.domain.Agendamento;
import com.barbearia.dfael.domain.Barbeiro;
import com.barbearia.dfael.domain.Servico;
import com.barbearia.dfael.domain.Usuario;
import com.barbearia.dfael.domain.enums.StatusAgendamento;

import java.util.Date;

public class AgendamentoDTO {
    private Long idAgendamento;
    private Date hora;
    private StatusAgendamento statusAgendamento;
    private String nomeUsuario;
    private String nomeBarbeiro;
    private String tipoServico;


    public AgendamentoDTO(){

    }

    public AgendamentoDTO(Agendamento obj) {
        idAgendamento = obj.getIdAgendamento();
        hora = obj.getHora();
        statusAgendamento = obj.getStatus();
        nomeUsuario = (obj.getUsuario()!= null) ? obj.getUsuario().getName() : null;
        nomeBarbeiro = (obj.getBarbeiro()!= null) ? obj.getBarbeiro().getName() : null;
        tipoServico = (obj.getServico()!= null) ? obj.getServico().getNomeServico() : null;

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

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeBarbeiro() {
        return nomeBarbeiro;
    }

    public void setNomeBarbeiro(String nomeBarbeiro) {
        this.nomeBarbeiro = nomeBarbeiro;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }


}
