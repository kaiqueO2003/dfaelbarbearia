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
    private UsuarioDTO usuario;
    private BarbeiroDTO barbeiro;
    private ServicoDTO servico;


    public AgendamentoDTO(){

    }

    public AgendamentoDTO(Agendamento obj) {
        idAgendamento = obj.getIdAgendamento();
        hora = obj.getHora();
        statusAgendamento = obj.getStatus();
        this.usuario = (obj.getUsuario() != null) ? new UsuarioDTO(obj.getUsuario()) : null;
        this.barbeiro = (obj.getBarbeiro() != null) ? new BarbeiroDTO(obj.getBarbeiro()) : null;
        this.servico = (obj.getServico() != null) ? new ServicoDTO(obj.getServico()) : null;

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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public BarbeiroDTO getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(BarbeiroDTO barbeiro) {
        this.barbeiro = barbeiro;
    }

    public ServicoDTO getServico() {
        return servico;
    }

    public void setServico(ServicoDTO servico) {
        this.servico = servico;
    }
}
