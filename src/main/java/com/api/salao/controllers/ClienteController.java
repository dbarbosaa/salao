package com.api.salao.controllers;

import com.api.salao.models.ClienteModel;
import com.api.salao.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @Operation(summary = "Salvar cliente")
    public ResponseEntity<Object> Save(@RequestBody ClienteModel cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.Save(cliente));
    }

    @GetMapping("/all")
    @Operation(summary = "Buscar cliente por paginação")
    public ResponseEntity<Page<ClienteModel>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.FindAll(pageable));
    }
    @GetMapping("/{id}")
    @Operation(summary = "Buscar cliente por Id")
    public ResponseEntity<Object> FindById(@PathVariable(value = "id") long id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.FindById(id));
    }
}