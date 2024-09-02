package com.api.salao.repositories;

import com.api.salao.models.ProfissionalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfissionalRepository extends JpaRepository<ProfissionalModel, UUID> {

}