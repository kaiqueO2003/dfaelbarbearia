package com.barbearia.dfael.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@Entity
public class Pagamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;
    private Double valorTotal;
    private String metodoPagamemto;

    @OneToOne(mappedBy = "pagamento")
    private Agendamento agendamento;

    public Pagamento(){

    }

    public Pagamento(Long idPagamento, Double valorTotal, String metodoPagamemto) {
        this.idPagamento = idPagamento;
        this.valorTotal = valorTotal;
        this.metodoPagamemto = metodoPagamemto;
    }

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getMetodoPagamemto() {
        return metodoPagamemto;
    }

    public void setMetodoPagamemto(String metodoPagamemto) {
        this.metodoPagamemto = metodoPagamemto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(idPagamento, pagamento.idPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPagamento);
    }
}
