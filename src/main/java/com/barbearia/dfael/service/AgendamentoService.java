package com.barbearia.dfael.service;

import com.barbearia.dfael.domain.Agendamento;
import com.barbearia.dfael.domain.Barbeiro;
import com.barbearia.dfael.domain.Servico;
import com.barbearia.dfael.domain.Usuario;
import com.barbearia.dfael.domain.dto.AgendamentoDTO;
import com.barbearia.dfael.domain.enums.StatusAgendamento;
import com.barbearia.dfael.repository.BarbeiroRepository;
import com.barbearia.dfael.repository.ServicoRepository;
import com.barbearia.dfael.repository.UsuarioRepository;
import com.barbearia.dfael.service.exception.DatabaseException;
import com.barbearia.dfael.service.exception.ResourceNotFoundException;
import com.barbearia.dfael.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {
    @Autowired
    AgendamentoRepository repo;
    @Autowired
    ServicoRepository servicoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    BarbeiroRepository barbeiroRepository;

    @Autowired
    NotificacaoService notificacaoService;

    public Agendamento insert(Agendamento obj){
        try {
            return repo.save(obj);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("erro ao inserir agendamento"+ e.getMessage());
        }

    }

    public List<Agendamento> findAll(){
        return repo.findAll();
    }
    public Agendamento findByid(String id){
        Optional<Agendamento> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Agendamento não encontrado com o id: " + id));
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
    public AgendamentoDTO solicitarAgendamento(AgendamentoDTO agendamentoDTO) {
        Agendamento agendamento = new Agendamento();
        agendamento.setHora(agendamentoDTO.getHora());
        agendamento.setStatus(StatusAgendamento.PENDENTE);

        Usuario usuario = usuarioRepository.findById(agendamentoDTO.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        agendamento.setUsuario(usuario);

        Barbeiro barbeiro = barbeiroRepository.findById(agendamentoDTO.getBarbeiro().getId())
                .orElseThrow(() -> new RuntimeException("Barbeiro não encontrado"));
        agendamento.setBarbeiro(barbeiro);

        Servico servico = servicoRepository.findById(agendamentoDTO.getServico().getIdServico())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        agendamento.setServico(servico);
        Agendamento novoAgendamento = repo.save(agendamento);
        return new AgendamentoDTO(novoAgendamento);
    }
    @Scheduled(fixedRate = 60000)
    public void enviarLembretes() {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime proximaHora = agora.plusHours(1);

        List<Agendamento> agendamentosConfirmados = repo.findAgendamentosByHoraAndStatus(agora, proximaHora, StatusAgendamento.CONFIRMADO);

        if (agendamentosConfirmados.isEmpty()) {
            System.out.println("Nenhum agendamento confirmado para enviar lembrete.");
        } else {
            for (Agendamento agendamento : agendamentosConfirmados) {
                String telefone = agendamento.getUsuario().getTelefone();
                String mensagem = "Lembrete: Você tem um agendamento com o barbeiro " +
                        agendamento.getBarbeiro().getName() + " às " + agendamento.getHora() + ". Não se atrase!";
                notificacaoService.enviarNotificacao(telefone, mensagem);
                System.out.println("Enviando lembrete para: " + telefone);
            }
        }
    }


    public List<AgendamentoDTO> listarAgendamentosPendentes(String idBarbeiro){
        List<Agendamento> agendamentos = repo.findByBarbeiroIdAndStatus(idBarbeiro, StatusAgendamento.PENDENTE);
        System.out.println("Agendamentos pendentes: " + agendamentos);
        return agendamentos.stream().map(AgendamentoDTO::new).collect(Collectors.toList());
    }

}
