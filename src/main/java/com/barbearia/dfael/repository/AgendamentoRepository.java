package com.barbearia.dfael.repository;

import com.barbearia.dfael.domain.Agendamento;
import com.barbearia.dfael.domain.enums.StatusAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, String> {
    List<Agendamento> findByBarbeiroIdAndStatus(String idBarbeiro, StatusAgendamento statusAgendamento);

    @Query("SELECT a FROM Agendamento a WHERE a.hora BETWEEN :inicio AND :fim AND a.status = :status")
    List<Agendamento> findAgendamentosByHoraAndStatus(@Param("inicio") LocalDateTime inicio,
                                                      @Param("fim") LocalDateTime fim,
                                                      @Param("status") StatusAgendamento status);

}
