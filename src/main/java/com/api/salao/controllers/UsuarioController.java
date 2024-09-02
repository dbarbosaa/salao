package com.api.salao.controllers;

import com.api.salao.models.UsuarioModel;
import com.api.salao.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    final UsuarioService userService;

    public UsuarioController(UsuarioService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Operation(summary = "Salvar usuario")
    public ResponseEntity<Object> Save(@RequestBody UsuarioModel usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.Save(usuario));
    }

    @GetMapping("/all")
    @Operation(summary = "Buscar usuario por paginação")
    public ResponseEntity<Page<UsuarioModel>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userService.FindAll(pageable));
    }
    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuario por Id")
    public ResponseEntity<Object> FindById(@PathVariable(value = "id") long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.FindById(id));
    }
}