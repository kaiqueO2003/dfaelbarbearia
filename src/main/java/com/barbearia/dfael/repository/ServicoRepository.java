package com.barbearia.dfael.repository;

import com.barbearia.dfael.domain.Agendamento;
import com.barbearia.dfael.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, String> {
    
}
