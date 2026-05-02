package com.wllr.sistema_campanhas_atacadao_farias.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;

    @Column(name = "razao_social", nullable = false, length = 100)
    private String razaoSocial;

    private String cidade;

    private Boolean ativo;
}
