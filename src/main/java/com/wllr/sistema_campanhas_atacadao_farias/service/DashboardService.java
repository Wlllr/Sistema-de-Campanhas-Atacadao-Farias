package com.wllr.sistema_campanhas_atacadao_farias.service;

import com.wllr.sistema_campanhas_atacadao_farias.dto.DashboardDTO;
import com.wllr.sistema_campanhas_atacadao_farias.model.Metas;
import com.wllr.sistema_campanhas_atacadao_farias.model.Venda;
import com.wllr.sistema_campanhas_atacadao_farias.model.Vendedor;
import com.wllr.sistema_campanhas_atacadao_farias.repository.MetasRepository;
import com.wllr.sistema_campanhas_atacadao_farias.repository.VendaRepository;
import com.wllr.sistema_campanhas_atacadao_farias.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private MetasRepository metasRepository;

    public DashboardDTO obterDadosDashboard(Integer idVendedor) {
        Vendedor vendedor = buscarVendedor(idVendedor);

        // 2. Definir o periodo (Mes atual)
        LocalDate inicioMes = LocalDate.now().withDayOfMonth(1);
        LocalDate fimMes = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());

        // 3.Buscar a meta do vendedor para o mes atual
        Metas meta = buscarMeta(idVendedor, inicioMes);
        BigDecimal totalVendido = calcularTotalVendas(idVendedor, inicioMes, fimMes);

        return montarDashboardDTO(meta, totalVendido, vendedor);
    }

    private static DashboardDTO montarDashboardDTO(Metas meta, BigDecimal totalVendido, Vendedor vendedor) {
        // 6. Calculos de atingimento
        BigDecimal valorMeta = (meta != null) ? meta.getValorMeta() : BigDecimal.ZERO;
        BigDecimal quantoFalta = valorMeta.subtract(totalVendido).max(BigDecimal.ZERO);

        Double percentual = 0.0;
        if (valorMeta.compareTo(BigDecimal.ZERO) > 0) {
            percentual = totalVendido.divide(valorMeta, 4, RoundingMode.HALF_UP)
                    .multiply(new BigDecimal("100")).doubleValue();
        }

        // 7. Montar o DTO (ou Record) para retornar
        return new DashboardDTO(
                vendedor.getNome(),
                totalVendido,
                valorMeta,
                quantoFalta,
                percentual,
                totalVendido.compareTo(valorMeta) >= 0
        );
    }

    private BigDecimal calcularTotalVendas(Integer idVendedor, LocalDate inicioMes, LocalDate fimMes) {
        // 4. Buscar as vendas do vendedor no periodo
        List<Venda> vendas = vendaRepository.findByVendedorIdAndDataVendaBetween(
                idVendedor,
                inicioMes.atStartOfDay(),
                fimMes.atTime(23, 59, 59)
        );

        // 5. Calcular o total vendido (Soma dos valores das vendas)
        return vendas.stream()
                .map(Venda::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // 3.Buscar a meta do vendedor para o mes atual
    private Metas buscarMeta(Integer idVendedor, LocalDate inicioMes) {
        return metasRepository.findByVendedorIdAndMesReferencia(idVendedor, inicioMes)
                .orElse(null);
    }

    // 1. Busca o vendedor ou lança erro se não existir
    private Vendedor buscarVendedor(Integer idVendedor) {
        return vendedorRepository.findById(idVendedor)
                .orElseThrow(() -> new RuntimeException("Vendedor não encontrado"));
    }
}
