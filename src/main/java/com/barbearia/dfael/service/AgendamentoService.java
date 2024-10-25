package com.barbearia.dfael.service;

import com.barbearia.dfael.domain.Agendamento;
import com.barbearia.dfael.domain.Barbeiro;
import com.barbearia.dfael.domain.dto.AgendamentoDTO;
import com.barbearia.dfael.domain.enums.StatusAgendamento;
import com.barbearia.dfael.exception.ResourceNotFoundException;
import com.barbearia.dfael.repository.AgendamentoRepository;
import com.barbearia.dfael.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {
    @Autowired
    AgendamentoRepository repo;


    public Agendamento insert(Agendamento obj){
        return repo.save(obj);
    }

    public List<Agendamento> findAll(){
        return repo.findAll();
    }
    public Agendamento findByid(String id){
        Optional<Agendamento> obj = repo.findById(id);
        return obj.get();
    }
    public Agendamento confirmarAgendamento(String id){
        Agendamento agendamento = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agendamento não encontrado com o id: " + id));
        agendamento.setStatus(StatusAgendamento.CONFIRMADO);
        return repo.save(agendamento);
    }
    public Agendamento cancelarAgendamento(String id){
        Agendamento agendamento = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agendamento não encontrado com o id: " + id));
        agendamento.setStatus(StatusAgendamento.CANCELADO);
        return repo.save(agendamento);
    }
    public AgendamentoDTO solicitarAgendamento(AgendamentoDTO agendamentoDTO){
        Agendamento agendamento = new Agendamento();
        agendamento.setHora(agendamentoDTO.getHora());
        agendamento.setStatus(StatusAgendamento.PENDENTE);

        Agendamento novoAgendamento = repo.save(agendamento);
        return new AgendamentoDTO();
    }
    public List<AgendamentoDTO> listarAgendamentosPendentes(String idBarbeiro){
        List<Agendamento> agendamentos = repo.findByBarbeiroIdAndStatus(idBarbeiro, StatusAgendamento.PENDENTE);
        System.out.println("Agendamentos pendentes: " + agendamentos); // Adicione isso
        return agendamentos.stream().map(AgendamentoDTO::new).collect(Collectors.toList());
    }
}
