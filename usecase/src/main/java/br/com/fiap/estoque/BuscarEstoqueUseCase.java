package br.com.fiap.estoque;

import br.com.fiap.model.Estoque;

import java.util.Optional;

public interface BuscarEstoqueUseCase {
    Optional<Estoque> buscarPorId(Long id);

    Optional<Estoque> buscarPorIdProduto(Long id);
}
