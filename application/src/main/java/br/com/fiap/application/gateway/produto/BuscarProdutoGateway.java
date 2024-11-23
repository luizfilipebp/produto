package br.com.fiap.application.gateway.produto;

import br.com.fiap.model.Produto;

import java.util.Optional;

public interface BuscarProdutoGateway {
    Optional<Produto> buscar(long id);
}
