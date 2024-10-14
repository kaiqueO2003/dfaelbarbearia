package com.barbearia.dfael.domain.enums;

public enum UsuarioRole {
    ADMIN("admin"),

    BARBEIRO ("barbeiro"),

    USUARIO ("usuario");

    private String role;

    UsuarioRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}

