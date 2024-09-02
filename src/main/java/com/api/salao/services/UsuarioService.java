package com.api.salao.services;
import com.api.salao.models.UsuarioModel;
import com.api.salao.repositories.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {

    final UsuarioRepository userRepository;

    public UsuarioService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UsuarioModel Save(UsuarioModel userModel) {
        return userRepository.save(userModel);
    }

    public Page<UsuarioModel> FindAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Optional<UsuarioModel> FindById(long id) {
        var users = userRepository.findAll();
        return users.stream().findFirst();
    }

    public UsuarioModel login(String email, String senha) {
        UsuarioModel user = userRepository.findByEmailAndSenha(email, senha);
        if (user != null) {
            return user;
        } else {
            throw new RuntimeException("Não existe esse usuário");
        }
    }


}
