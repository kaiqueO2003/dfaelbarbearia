package com.barbearia.dfael.domain.dto;

import com.barbearia.dfael.domain.Agendamento;
import com.barbearia.dfael.domain.Barbeiro;
import com.barbearia.dfael.domain.Servico;
import com.barbearia.dfael.domain.Usuario;
import com.barbearia.dfael.domain.enums.StatusAgendamento;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class AgendamentoDTO {
    private Long idAgendamento;
    @NotNull(message = "Hora do agendamento é obrigatória")
    private Date hora;
    private StatusAgendamento statusAgendamento;
    @NotNull(message = "Usuario nao pode ser nulo")
    private UsuarioDTO usuario;
    @NotNull(message = "Barbeiro nao pode ser nulo")
    private BarbeiroDTO barbeiro;
    @NotNull(message = "Serviço nao pode ser nulo")
    private ServicoDTO servico;


    public AgendamentoDTO(){

    }

    public AgendamentoDTO(Agendamento obj) {

            idAgendamento = obj.getIdAgendamento();
            hora = obj.getHora();
            statusAgendamento = obj.getStatus();
            this.usuario = new UsuarioDTO(obj.getUsuario()); // Use 'obj' para acessar os dados
            this.barbeiro = new BarbeiroDTO(obj.getBarbeiro()); // Use 'obj' para acessar os dados
            this.servico = new ServicoDTO(obj.getServico()); // Use 'obj' para acessar os dados


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
