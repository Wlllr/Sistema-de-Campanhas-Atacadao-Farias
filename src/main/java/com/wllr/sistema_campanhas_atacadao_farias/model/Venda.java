package com.wllr.sistema_campanhas_atacadao_farias.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Integer id;

    @Column(name = "data_venda")
    private LocalDate dataVenda;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    // Relacionamento de Venda com Vededor MUITAS para UM
    @ManyToOne // UM Vendedor pode ter MUITAS Vendas
    @JoinColumn(name = "id_vendedor") // FK para conectar com Vendedor
    private Vendedor vendedor;

    @ManyToOne // UM cliente pode ter MUITAS compras
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // Relacionamento Inverso: UMA Venda tem uma LISTA de itens
    // O 'mappedBy' aponta para o nome do campo dentro da classe ItemVenda
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itens;
}
