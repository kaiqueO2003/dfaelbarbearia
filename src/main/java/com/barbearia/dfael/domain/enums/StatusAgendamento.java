package com.barbearia.dfael.domain.enums;

public enum StatusAgendamento {
    CONFIRMADO("confirmado"),
    CANCELADO("cancelado"),
    PENDENTE("pendente");

    private String status;

    StatusAgendamento(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static StatusAgendamento fromString(String status) {
        for (StatusAgendamento s : StatusAgendamento.values()) {
            if (s.getStatus().equalsIgnoreCase(status)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Status não encontrado: " + status);
    }
}

