package com.wllr.sistema_campanhas_atacadao_farias.model;


import jakarta.persistence.*;
import lombok.Data;

@Data // Lombok cria os getters, setters e toString
@Entity //Diz que esta classe eh uma tabela no banco
@Table(name = "Filial") // Nome da tabela como eh no banco
public class Filial {

    @Id // chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment no MySQL
    @Column(name = "id_filial") // nome da coluna no banco
    private Integer id;

    @Column(nullable = false, length = 100) // not null e o tamanho
    private String nome;

    private String cidade; // como o nome do campo é igual o da coluna, o @Column se torna opcional
}
