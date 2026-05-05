package com.wllr.sistema_campanhas_atacadao_farias.repository;

import com.wllr.sistema_campanhas_atacadao_farias.model.Metas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface MetasRepository extends JpaRepository<Metas, Integer> {

    // O Spring gera: SELECT * FROM Metas WHERE id_vendedor = ? AND mes_referencia = ?
    Optional<Metas> findByVendedorIdAndMesReferencia(Integer idVendedor, LocalDate data);
}
