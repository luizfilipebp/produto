package br.com.fiap.usecase.produto;

import br.com.fiap.core.model.Produto;

import java.util.Optional;

public interface BuscarProdutoUseCase {
    Optional<Produto> buscarPorId(Long id);
}
