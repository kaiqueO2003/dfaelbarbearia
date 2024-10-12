package com.barbearia.dfael.domain.dto;

import com.barbearia.dfael.domain.enums.UsuarioRole;

public record CadastroDTO(String name, String email, String password, UsuarioRole role){
}
