package br.com.fiap.infrastructure.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prd_id")
    private Long id;

    @Column(name = "prd_nome")
    private String nome;

    @Column(name = "prd_descricao")
    private String descricao;

    @Column(name = "prd_preco")
    private BigDecimal preco;
}
