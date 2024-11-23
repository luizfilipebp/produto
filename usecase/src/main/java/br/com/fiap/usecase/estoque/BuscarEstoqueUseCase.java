package br.com.fiap.usecase.estoque;

import br.com.fiap.core.model.Estoque;

import java.util.Optional;

public interface BuscarEstoqueUseCase {
    Optional<Estoque> buscarPorId(Long id);

    Optional<Estoque> buscarPorIdProduto(Long id);
}
