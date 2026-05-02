package com.wllr.sistema_campanhas_atacadao_farias.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vendedor")
    private Integer id;

    @Column(nullable = false)
    private String nome;

    // Relacionamento de Vendedor com Filial
    @ManyToOne // Muitos vendedores pertecem a UMA Filial
    @JoinColumn(name = "id_filial")
    private Filial filial;

}
