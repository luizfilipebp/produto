package br.com.fiap.application.gateway.estoque;

import br.com.fiap.core.model.Estoque;

import java.util.Optional;

public interface BuscarEstoqueGateway {
    Optional<Estoque> buscarPorId(Long id);

    Optional<Estoque> buscarPorIdProduto(Long id);
}
