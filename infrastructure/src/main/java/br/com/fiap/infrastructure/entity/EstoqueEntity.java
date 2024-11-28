package br.com.fiap.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estoque")
public class EstoqueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "est_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "est_produto_id")
    private ProdutoEntity produto;

    @Column(name = "est_quantidade")
    private Integer quantidade;
}
