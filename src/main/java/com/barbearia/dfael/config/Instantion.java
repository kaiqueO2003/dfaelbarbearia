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
public class  Instantion implements CommandLineRunner {
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");


        Usuario kaique = new Usuario(null, "Kaique", "kaique@gmail.com","123", "+5511951411178",  ADMIN);
        Usuario ana = new Usuario(null, "Ana", "ana@gmail.com", "123","11951411178", USUARIO);
        Usuario kaio = new Usuario(null, "Kaio","kaio@gmail.com","123", "+5511951411178", USUARIO);


        usuarioRepository.saveAll(Arrays.asList(kaique, ana, kaio));

        Barbeiro ryan = new Barbeiro(null, "Ryan", "ryan@gmail.com", "123", "11912345678", BARBEIRO, "barba e cabelo", "qualquer horario", 5.0);
        Barbeiro lucas = new Barbeiro(null, "Lucas", "lucas@gmail.com", "123", "11912345678", BARBEIRO, "barba", "qualquer horario", 5.0);

        barbeiroRepository.saveAll(Arrays.asList(ryan, lucas));

        Servico cabelo = new Servico(null, "cabelo", 30, 40.00);
        Servico barba = new Servico(null, "barba", 30, 40.00);
        servicoRepository.saveAll(Arrays.asList(cabelo, barba));

        Agendamento agendamento1 = new Agendamento(null, kaique, ryan, cabelo, sdf.parse("05/11/2024 13:50"), StatusAgendamento.PENDENTE);
        Agendamento agendamento2 = new Agendamento(null, kaique, lucas, cabelo, sdf.parse("05/11/2024 13:49"), StatusAgendamento.PENDENTE);
        Agendamento agendamento3 = new Agendamento(null, kaio, lucas, barba, Date.from(Instant.now()), StatusAgendamento.PENDENTE);


        agendamentoRepository.saveAll(Arrays.asList(agendamento1, agendamento2, agendamento3));
    }

}
