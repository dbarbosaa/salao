package com.api.salao.services;

import com.api.salao.models.ServicoModel;
import com.api.salao.repositories.ServicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoService {

    final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public ServicoModel Save(ServicoModel servicoModel) {
        return servicoRepository.save(servicoModel);
    }
    public Page<ServicoModel> FindAll(Pageable pageable) {
        return servicoRepository.findAll(pageable);
    }

    public Optional<ServicoModel> FindById(long id) {
        var users = servicoRepository.findAll();
        return  users.stream().findFirst();
    }
}