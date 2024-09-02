package com.api.salao.services;

import com.api.salao.models.ProfissionalModel;
import com.api.salao.repositories.ProfissionalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfissionalService {

    final ProfissionalRepository profissionalRepository;

    public ProfissionalService(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    public ProfissionalModel Save(ProfissionalModel profissionalModel) {
        return profissionalRepository.save(profissionalModel);
    }
    public Page<ProfissionalModel> FindAll(Pageable pageable) {
        return profissionalRepository.findAll(pageable);
    }

    public Optional<ProfissionalModel> FindById(long id) {
        var users = profissionalRepository.findAll();
        return  users.stream().findFirst();
    }
}