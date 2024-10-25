package com.barbearia.dfael.repository;

import com.barbearia.dfael.domain.Agendamento;
import com.barbearia.dfael.domain.enums.StatusAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, String> {
    List<Agendamento> findByBarbeiroIdAndStatus(String idBarbeiro, StatusAgendamento statusAgendamento);
}
