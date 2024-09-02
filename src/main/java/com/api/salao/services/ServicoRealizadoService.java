package com.api.salao.services;

import com.api.salao.models.ServicoRealizadoModel;
import com.api.salao.repositories.ServicoRealizadoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoRealizadoService {

    final ServicoRealizadoRepository servicoRealizadoRepository;

    public ServicoRealizadoService(ServicoRealizadoRepository servicoRealizadoRepository) {
        this.servicoRealizadoRepository = servicoRealizadoRepository;
    }

    public ServicoRealizadoModel save(ServicoRealizadoModel servicoRealizadoModel) {
        return servicoRealizadoRepository.save(servicoRealizadoModel);
    }

    public Page<ServicoRealizadoModel> findAll(Pageable pageable) {
        return servicoRealizadoRepository.findAll(pageable);
    }

    public Optional<ServicoRealizadoModel> findById(long id) {
        return servicoRealizadoRepository.findById(id);
    }

    public void deleteById(Long id) {
        servicoRealizadoRepository.deleteById(id);
    }
}