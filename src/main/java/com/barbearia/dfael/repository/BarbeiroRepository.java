package com.barbearia.dfael.repository;

import com.barbearia.dfael.domain.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, String> {
}
