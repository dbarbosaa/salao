package com.api.salao.controllers;

import com.api.salao.helpes.exception.ProfissionalNaoDisponivelException;
import com.api.salao.models.AgendamentoModel;
import com.api.salao.services.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    @Operation(summary = "Salvar agendamento")
    public ResponseEntity<Object> save(@RequestBody AgendamentoModel agendamento) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoService.Save(agendamento));
        } catch (ProfissionalNaoDisponivelException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping("/alter")
    @Operation(summary = "Alterar agendamento")
    public ResponseEntity<Object> alter(@RequestBody AgendamentoModel agendamento) {
            return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoService.Alter(agendamento));
    }


    @GetMapping("/all")
    @Operation(summary = "Buscar agendamento por paginação")
    public ResponseEntity<Page<AgendamentoModel>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.FindAll(pageable));
    }
    @GetMapping("/{id}")
    @Operation(summary = "Buscar agendamento por Id")
    public ResponseEntity<Object> FindById(@PathVariable(value = "id") long id){
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.FindById(id));
    }
}