package br.com.fiap.infrastructure.dto.produto;

import java.math.BigDecimal;

public record ProdutoPostReqBody(String nome, String descricao, BigDecimal preco) {
}
