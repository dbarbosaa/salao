package com.api.salao.controllers;

import com.api.salao.models.ServicoModel;
import com.api.salao.services.ServicoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @PostMapping
    @Operation(summary = "Salvar serviço")
    public ResponseEntity<Object> Save(@RequestBody ServicoModel servico){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoService.Save(servico));
    }

    @GetMapping("/all")
    @Operation(summary = "Buscar serviço por paginação")
    public ResponseEntity<Page<ServicoModel>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(servicoService.FindAll(pageable));
    }
    @GetMapping("/{id}")
    @Operation(summary = "Buscar serviço por Id")
    public ResponseEntity<Object> FindById(@PathVariable(value = "id") long id){
        return ResponseEntity.status(HttpStatus.OK).body(servicoService.FindById(id));
    }
}