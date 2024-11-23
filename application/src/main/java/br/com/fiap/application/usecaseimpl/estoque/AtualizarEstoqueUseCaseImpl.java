package br.com.fiap.application.usecaseimpl.estoque;

import br.com.fiap.application.gateway.estoque.AtualizarEstoqueGateway;
import br.com.fiap.application.gateway.estoque.BuscarEstoqueGateway;
import br.com.fiap.core.model.Estoque;
import br.com.fiap.usecase.estoque.AtualizarEstoqueUseCase;

public class AtualizarEstoqueUseCaseImpl implements AtualizarEstoqueUseCase {

    private final BuscarEstoqueGateway buscarEstoqueGateway;
    private final AtualizarEstoqueGateway atualizarEstoqueGateway;

    public AtualizarEstoqueUseCaseImpl(BuscarEstoqueGateway buscarEstoqueUseCase, AtualizarEstoqueGateway atualizarEstoqueGateway) {
        this.buscarEstoqueGateway = buscarEstoqueUseCase;
        this.atualizarEstoqueGateway = atualizarEstoqueGateway;
    }

    @Override
    public Estoque atualizar(Estoque estoque) {
        buscarEstoqueGateway.buscarPorId(estoque.getId()).orElseThrow(() -> new RuntimeException("Estoque não encontrado"));
        return atualizarEstoqueGateway.atualizar(estoque);
    }
}
