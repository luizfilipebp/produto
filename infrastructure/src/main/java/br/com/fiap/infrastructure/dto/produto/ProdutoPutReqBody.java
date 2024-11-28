package br.com.fiap.infrastructure.dto.produto;

import java.math.BigDecimal;

public record ProdutoPutReqBody(Long id, String nome, String descricao, BigDecimal preco) {
}
