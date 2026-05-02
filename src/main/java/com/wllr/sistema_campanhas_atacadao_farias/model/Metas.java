package com.wllr.sistema_campanhas_atacadao_farias.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Metas")
public class Metas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meta")
    private Integer id;

    @Column(name = "mes_referencia")
    private LocalDate mesReferencia;

    @Column(name = "valor_meta")
    private BigDecimal valorMeta;

    @ManyToOne // UM Vendedor pode ter MUITAS Metas
    @JoinColumn(name = "id_vendedor")
    private Vendedor vendedor;
}
