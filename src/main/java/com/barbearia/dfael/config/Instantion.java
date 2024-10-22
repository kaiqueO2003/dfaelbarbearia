package com.barbearia.dfael.config;

import com.barbearia.dfael.domain.Agendamento;
import com.barbearia.dfael.domain.Barbeiro;
import com.barbearia.dfael.domain.Servico;
import com.barbearia.dfael.domain.Usuario;
import com.barbearia.dfael.domain.enums.StatusAgendamento;
import com.barbearia.dfael.repository.AgendamentoRepository;
import com.barbearia.dfael.repository.BarbeiroRepository;
import com.barbearia.dfael.repository.ServicoRepository;
import com.barbearia.dfael.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import static com.barbearia.dfael.domain.enums.UsuarioRole.*;

@Configuration
public class Instantion implements CommandLineRunner {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    BarbeiroRepository barbeiroRepository;
    @Autowired
    AgendamentoRepository agendamentoRepository;
    @Autowired
    ServicoRepository servicoRepository;


    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Usuario kaique = new Usuario("null","Kaique", "kaique@gmail.com", "123",ADMIN);
        Usuario ana = new Usuario("null","ana", "ana@gmail.com", "123", USUARIO);

        usuarioRepository.saveAll(Arrays.asList(kaique, ana));

        Barbeiro ryan = new Barbeiro("null", "Ryan", "ryan@gmail.com", "123", BARBEIRO, "barba e cabelo", "qualquer horario", 5.0);
        Usuario lucas = new Barbeiro("null", "Lucas", "lucas@gmail.com", "123", BARBEIRO, "barba", "qualquer horario", 5.0);
        usuarioRepository.saveAll(Arrays.asList(ryan,lucas ));

        Servico cabelo = new Servico(null, "cabelo", 30, 40.00 );
        servicoRepository.saveAll(Arrays.asList(cabelo ));


    }

}