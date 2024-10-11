package com.barbearia.dfael.domain.enums;

public enum StatusAgendamento {
    CONFIRMADO("confirmado"),
    CANCELADO ("cancelado"),
    REALIZADO ("realizado");

    private String status;

    StatusAgendamento(String status) {
        this.status = status;
    }
}
