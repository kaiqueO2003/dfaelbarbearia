package com.barbearia.dfael.controller;


import com.barbearia.dfael.domain.Agendamento;
import com.barbearia.dfael.domain.Barbeiro;
import com.barbearia.dfael.domain.Usuario;
import com.barbearia.dfael.domain.dto.AgendamentoDTO;
import com.barbearia.dfael.domain.dto.BarbeiroDTO;
import com.barbearia.dfael.domain.enums.StatusAgendamento;
import com.barbearia.dfael.repository.UsuarioRepository;
import com.barbearia.dfael.service.AgendamentoService;
import com.barbearia.dfael.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoController {

    @Autowired
    AgendamentoService service;

    @Autowired
    NotificacaoService notificacaoService;



    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> findAll() {
        List<Agendamento> list = service.findAll();
        List<AgendamentoDTO> agendamentoDto = list.stream().map(x -> new AgendamentoDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(agendamentoDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AgendamentoDTO> findById(@PathVariable String id) {
        Agendamento obj = service.findByid(id);
        return ResponseEntity.ok().body(new AgendamentoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Agendamento> insert(@RequestBody Agendamento obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    @PutMapping("/confirmar/{id}")
    public ResponseEntity<AgendamentoDTO> confirmarAgendamento(@PathVariable String id) {
        Agendamento agendamentoConfirmado = service.confirmarAgendamento(id);
        AgendamentoDTO agendamentoDTO = new AgendamentoDTO(agendamentoConfirmado);

        String usuarioTelefone = agendamentoConfirmado.getUsuario().getTelefone();
        String mensagem = "Seu agendamento foi confirmado para " + agendamentoConfirmado.getHora();
        notificacaoService.enviarNotificacao(usuarioTelefone, mensagem);
        return ResponseEntity.ok().body(agendamentoDTO);

    }
    @PutMapping("/cancelar/{id}")
    public ResponseEntity<AgendamentoDTO> cancelarAgendamento(@PathVariable String id) {
        Agendamento agendamentoCancelado = service.cancelarAgendamento(id);
        AgendamentoDTO agendamentoDTO = new AgendamentoDTO(agendamentoCancelado);
        String usuarioTelefone = agendamentoCancelado.getUsuario().getTelefone();
        String mensagem = "Seu agendamento foi confirmado para " + agendamentoCancelado.getHora();
        notificacaoService.enviarNotificacao(usuarioTelefone, mensagem);
        return ResponseEntity.ok().body(agendamentoDTO);
    }

    @PutMapping("/solicitar")
    public ResponseEntity<AgendamentoDTO> solicitarAgendamento(@RequestBody AgendamentoDTO agendamentoDTO) {
        AgendamentoDTO novoAgendamento = service.solicitarAgendamento(agendamentoDTO);
        return ResponseEntity.ok(novoAgendamento);
    }
    @GetMapping("/barbeiro/{idBarbeiro}/pendentes")
    public ResponseEntity<List<AgendamentoDTO>> listarAgendamentosPendentes(@PathVariable String idBarbeiro) {
        List<AgendamentoDTO> agendamentosPendentes=service.listarAgendamentosPendentes(idBarbeiro);
        return ResponseEntity.ok().body(agendamentosPendentes);
    }

}