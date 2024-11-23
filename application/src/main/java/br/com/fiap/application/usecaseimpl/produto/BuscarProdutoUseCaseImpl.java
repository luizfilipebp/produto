package br.com.fiap.application.usecaseimpl.produto;

import br.com.fiap.application.gateway.produto.BuscarProdutoGateway;
import br.com.fiap.model.Produto;
import br.com.fiap.produto.BuscarProdutoUseCase;

import java.util.Optional;

public class BuscarProdutoUseCaseImpl implements BuscarProdutoUseCase {
    private final BuscarProdutoGateway buscarProdutoGateway;

    public BuscarProdutoUseCaseImpl(BuscarProdutoGateway buscarProdutoGateway) {
        this.buscarProdutoGateway = buscarProdutoGateway;
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return buscarProdutoGateway.buscar(id);
    }
}
