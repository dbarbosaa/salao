package com.api.salao.repositories;

import com.api.salao.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {

    UsuarioModel findByEmailAndSenha(String email, String senha);
}
