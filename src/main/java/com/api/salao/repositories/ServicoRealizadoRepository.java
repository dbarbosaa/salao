package com.api.salao.repositories;

import com.api.salao.models.ServicoRealizadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRealizadoRepository extends JpaRepository<ServicoRealizadoModel, Long> {
}