package com.api.salao.controllers;

import com.api.salao.models.UsuarioModel;
import com.api.salao.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/autenticacao")
@CrossOrigin(origins = "http://localhost:8080")  // Substitua pelo domínio correto
public class AutenticacaoController {

    final UsuarioService usuarioService;

    public AutenticacaoController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/logar")
    public ResponseEntity<?> logar(@RequestBody Map<String, Object> requestBody) {
        try {
            String email = (String) requestBody.get("email");
            String senha = (String) requestBody.get("senha");

            if (email == null || senha == null) {
                throw new RuntimeException("Email e senha são obrigatórios");
            }

            UsuarioModel usuario = usuarioService.login(email, senha);
            Map<String, Object> response = new HashMap<>();
            response.put("usuario", usuario);
            response.put("token", "123456");  // Aqui deve estar sua lógica de geração de token

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
