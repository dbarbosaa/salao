package com.api.salao.repositories;

import com.api.salao.models.AgendamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {
    boolean existsByProfissionalIdAndDataHorario(Long profissionalId, LocalDateTime dataHorario);
}
