package com.wllr.sistema_campanhas_atacadao_farias.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor")
    private Integer id;

    @Column(name = "nome_fantasia", nullable = false, length = 100)
    private String nomeFantasia;

    @Column(unique = true)
    private String cnpj;
}
