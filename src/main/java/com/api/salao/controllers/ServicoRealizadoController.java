package com.api.salao.controllers;

import com.api.salao.models.ServicoRealizadoModel;
import com.api.salao.services.ServicoRealizadoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/servico-realizado")
public class ServicoRealizadoController {

    @Autowired
    private ServicoRealizadoService servicoRealizadoService;

    @GetMapping("/all")
    @Operation(summary = "Buscar serviços realizados por paginação")
    public ResponseEntity<Page<ServicoRealizadoModel>> findAll(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(servicoRealizadoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoRealizadoModel> findById(@PathVariable Long id) {
        Optional<ServicoRealizadoModel> servicoRealizado = servicoRealizadoService.findById(id);
        return servicoRealizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<ServicoRealizadoModel> save(@RequestBody ServicoRealizadoModel servicoRealizadoModel) {
        ServicoRealizadoModel novoServicoRealizado = servicoRealizadoService.save(servicoRealizadoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServicoRealizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<ServicoRealizadoModel> servicoRealizado = servicoRealizadoService.findById(id);

        if (servicoRealizado.isPresent()) {
            servicoRealizadoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}