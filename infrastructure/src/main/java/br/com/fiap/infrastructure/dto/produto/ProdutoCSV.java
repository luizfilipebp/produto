package br.com.fiap.infrastructure.dto.produto;

public record ProdutoCSV(String idProduto,
                         String nome,
                         String categoria,
                         String preco,
                         String estoque,
                         String descricao) {
}
