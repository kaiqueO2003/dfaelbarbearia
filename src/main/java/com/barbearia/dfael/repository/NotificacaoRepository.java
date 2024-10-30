
package com.barbearia.dfael.repository;

import com.barbearia.dfael.domain.Agendamento;
import com.barbearia.dfael.domain.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Notificacao, String> {
    
}
