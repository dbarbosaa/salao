package com.api.salao.controllers;

import com.api.salao.models.ProfissionalModel;
import com.api.salao.services.ProfissionalService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

    final ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }

    @PostMapping
    @Operation(summary = "Salvar profissional")
    public ResponseEntity<Object> Save(@RequestBody ProfissionalModel profissional){
        return ResponseEntity.status(HttpStatus.CREATED).body(profissionalService.Save(profissional));
    }

    @GetMapping("/all")
    @Operation(summary = "Buscar profissional por paginação")
    public ResponseEntity<Page<ProfissionalModel>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(profissionalService.FindAll(pageable));
    }
    @GetMapping("/{id}")
    @Operation(summary = "Buscar profissional por Id")
    public ResponseEntity<Object> FindById(@PathVariable(value = "id") long id){
        return ResponseEntity.status(HttpStatus.OK).body(profissionalService.FindById(id));
    }
}