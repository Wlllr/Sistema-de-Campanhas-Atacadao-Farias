package com.wllr.sistema_campanhas_atacadao_farias.dto;

import java.math.BigDecimal;

//Um Record é uma categoria especial de classe no Java projetada
// especificamente para ser um transportador de dados imutáveis.

//Perfeito para DTOs, pois os dados que saem para o celular do vendedor
// não precisam ser alterados no meio do caminho.

public record DashboardDTO(
        String nomeVededor,
        BigDecimal valorTotalVendido,
        BigDecimal valorMetaMensal,
        BigDecimal quantoFaltaParaMeta,
        Double percentualAtingido,
        Boolean metaBatida
) {
}
