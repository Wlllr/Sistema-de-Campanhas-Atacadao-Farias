package com.wllr.sistema_campanhas_atacadao_farias.repository;

import com.wllr.sistema_campanhas_atacadao_farias.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
