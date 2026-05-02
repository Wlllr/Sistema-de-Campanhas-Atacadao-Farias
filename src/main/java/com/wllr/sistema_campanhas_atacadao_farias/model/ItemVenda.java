package com.wllr.sistema_campanhas_atacadao_farias.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ItemVenda")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Integer id;

    private Integer quantidade;

    @Column(name = "valor_unitario_aplicado")
    private BigDecimal valorUnitarioAplicado;

    @ManyToOne // UM item pode estar em MUITOS Produtos
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @ManyToOne // UM item pode estar em MUITAS Vendas
    @JoinColumn(name = "id_venda")
    private Venda venda;
}
