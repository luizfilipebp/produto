package br.com.fiap.produto;

import br.com.fiap.model.Produto;

import java.util.Optional;

public interface BuscarProdutoUseCase {
    Optional<Produto> buscarPorId(Long id);
}
