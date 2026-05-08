package com.wllr.sistema_campanhas_atacadao_farias.controller;

import com.wllr.sistema_campanhas_atacadao_farias.dto.DashboardDTO;
import com.wllr.sistema_campanhas_atacadao_farias.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Diz que essa classe é uma API REST
@RequestMapping("api/dashboard") // Define a "rota" base
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/{idVendedor}")
    public ResponseEntity<DashboardDTO> obterDashboard(@PathVariable Integer idVendedor) {
        // Chama o service e encapsula a resposta padrão http
        DashboardDTO dados = dashboardService.obterDadosDashboard(idVendedor);
        return ResponseEntity.ok(dados);
    }
}
