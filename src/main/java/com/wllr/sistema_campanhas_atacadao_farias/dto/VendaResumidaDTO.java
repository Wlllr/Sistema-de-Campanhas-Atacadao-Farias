package com.wllr.sistema_campanhas_atacadao_farias.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VendaResumidaDTO(
        Integer idVenda,
        LocalDateTime data,
        String nomeCliente,
        BigDecimal valorTotal
) {
}
