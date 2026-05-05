package com.wllr.sistema_campanhas_atacadao_farias.repository;

import com.wllr.sistema_campanhas_atacadao_farias.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

    // SELECT * FROM Venda WHERE id_vendedor = ?
    // retorna uma lista, pois o vendedor tem uma lista de N vendas
    List<Venda> findByVendedorId(Integer idVendedor);

    // Busca as vendas de um vendedor dentre um intervalo de datas
    List<Venda> findByVendedorIdAndDataVendaBetween(Integer idVendedor, LocalDateTime inicio, LocalDateTime fim);
}
