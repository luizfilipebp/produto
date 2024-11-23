package br.com.fiap.application.usecaseimpl.estoque;

import br.com.fiap.application.gateway.estoque.BuscarEstoqueGateway;
import br.com.fiap.core.model.Estoque;
import br.com.fiap.usecase.estoque.BuscarEstoqueUseCase;

import java.util.Optional;

public class BuscarEstoqueUseCaseImpl implements BuscarEstoqueUseCase {
    private final BuscarEstoqueGateway buscarEstoqueGateway;

    public BuscarEstoqueUseCaseImpl(BuscarEstoqueGateway buscarEstoqueGateway) {
        this.buscarEstoqueGateway = buscarEstoqueGateway;
    }

    @Override
    public Optional<Estoque> buscarPorId(Long id) {
        return buscarEstoqueGateway.buscarPorId(id);
    }

    @Override
    public Optional<Estoque> buscarPorIdProduto(Long id) {
        return buscarEstoqueGateway.buscarPorIdProduto(id);
    }
}
