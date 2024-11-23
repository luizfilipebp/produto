package br.com.fiap.application.gateway.produto;

import br.com.fiap.core.model.Produto;

import java.util.Optional;

public interface BuscarProdutoGateway {
    Optional<Produto> buscar(long id);
}
