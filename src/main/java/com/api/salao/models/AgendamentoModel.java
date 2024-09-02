package com.api.salao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgendamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agendamento_id_seq")
    @SequenceGenerator(name = "agendamento_id_seq", sequenceName = "agendamento_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(name = "servico_id", nullable = false)
    private Long servicoId;

    @Column(name = "profissional_id", nullable = false)
    private Long profissionalId;

    @Column(name = "data_horario", nullable = false)
    private LocalDateTime dataHorario;

    @Column(nullable = false)
    private Boolean confirmado = false;

    @Column(nullable = false)
    private Boolean cancelado = false;

    @Column(name = "valor_pago", precision = 10, scale = 2)
    private BigDecimal valorPago;

    @Column(name = "taxa_cancelamento", precision = 10, scale = 2)
    private BigDecimal taxaCancelamento;
}