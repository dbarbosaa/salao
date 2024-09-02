package com.api.salao.services;

import com.api.salao.models.ClienteModel;
import com.api.salao.repositories.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteModel Save(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }
    public Page<ClienteModel> FindAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Optional<ClienteModel> FindById(long id) {
        var users = clienteRepository.findAll();
        return  users.stream().findFirst();
    }
}