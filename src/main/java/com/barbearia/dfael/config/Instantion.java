package com.barbearia.dfael.config;

import com.barbearia.dfael.domain.Barbeiro;
import com.barbearia.dfael.domain.Usuario;
import com.barbearia.dfael.repository.BarbeiroRepository;
import com.barbearia.dfael.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

import static com.barbearia.dfael.domain.enums.UsuarioRole.*;

@Configuration
public class Instantion implements CommandLineRunner {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    BarbeiroRepository barbeiroRepository;


    @Override
    public void run(String... args) throws Exception {
        Usuario kaique = new Usuario("null","Kaique", "kaique@gmail.com", "123",ADMIN);
        Usuario ana = new Usuario("null","ana", "ana@gmail.com", "123", USUARIO);

        usuarioRepository.saveAll(Arrays.asList(kaique, ana));

        Usuario ryan = new Barbeiro("null", "Ryan", "ryan@gmail.com", "123", BARBEIRO, "barba e cabelo", "qualquer horario", 5.0);

        usuarioRepository.saveAll(Arrays.asList(ryan));

    }

}
