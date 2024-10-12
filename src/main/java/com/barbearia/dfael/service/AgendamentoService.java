package com.barbearia.dfael.service;

import com.barbearia.dfael.repository.AgendamentoRepository;
import com.barbearia.dfael.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AgendamentoService {
    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;


}
