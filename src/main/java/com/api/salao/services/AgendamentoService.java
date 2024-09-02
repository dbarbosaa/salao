package com.api.salao.services;

import com.api.salao.helpes.exception.ProfissionalNaoDisponivelException;
import com.api.salao.models.AgendamentoModel;
import com.api.salao.repositories.AgendamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AgendamentoService {

    final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public AgendamentoModel Save(AgendamentoModel agendamentoModel) {
        if (isProfissionalDisponivel(agendamentoModel.getProfissionalId(), agendamentoModel.getDataHorario())) {
            return agendamentoRepository.save(agendamentoModel);
        } else {
            throw new ProfissionalNaoDisponivelException("O profissional não está disponível nesse horário.");
        }
    }
    public AgendamentoModel Alter(AgendamentoModel agendamentoModel) {
            return agendamentoRepository.save(agendamentoModel);
    }

    public Page<AgendamentoModel> FindAll(Pageable pageable) {
        return agendamentoRepository.findAll(pageable);
    }

    public Optional<AgendamentoModel> FindById(long id) {
        return agendamentoRepository.findById(id);
    }

    private boolean isProfissionalDisponivel(Long profissionalId, LocalDateTime dataHorario) {
        return !agendamentoRepository.existsByProfissionalIdAndDataHorario(profissionalId, dataHorario);
    }
}
