package com.barbearia.dfael.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
@Entity
public class Notificacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacao;
    private String mensagem;
    private Date dataHoraEnvio;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "barbeiro_id")
    private Barbeiro barbeiro;
    public Notificacao(){

    }

    public Notificacao(Long idNotificacao, String mensagem, Date dataHoraEnvio) {
        this.idNotificacao = idNotificacao;
        this.mensagem = mensagem;
        this.dataHoraEnvio = dataHoraEnvio;
    }

    public Long getIdNotificacao() {
        return idNotificacao;
    }

    public void setIdNotificacao(Long idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getDataHoraEnvio() {
        return dataHoraEnvio;
    }

    public void setDataHoraEnvio(Date dataHoraEnvio) {
        this.dataHoraEnvio = dataHoraEnvio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notificacao that = (Notificacao) o;
        return Objects.equals(idNotificacao, that.idNotificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idNotificacao);
    }
}
