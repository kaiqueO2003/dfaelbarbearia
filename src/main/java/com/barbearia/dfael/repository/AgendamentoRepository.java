package com.barbearia.dfael.repository;

import com.barbearia.dfael.domain.Agendamento;
import com.barbearia.dfael.domain.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, String> {
    
}
