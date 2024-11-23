package br.com.fiap.application.usecaseimpl.estoque;

import br.com.fiap.application.gateway.estoque.CadastrarEstoqueGateway;
import br.com.fiap.core.model.Estoque;
import br.com.fiap.usecase.estoque.CadastrarEstoqueUseCase;

public class CadastrarEstoqueUseCaseImpl implements CadastrarEstoqueUseCase {
    private final CadastrarEstoqueGateway cadastrarEstoqueGateway;

    public CadastrarEstoqueUseCaseImpl(CadastrarEstoqueGateway cadastrarEstoqueGateway) {
        this.cadastrarEstoqueGateway = cadastrarEstoqueGateway;
    }

    @Override
    public Estoque cadastrar(Estoque estoque) {
        return cadastrarEstoqueGateway.cadastrar(estoque);
    }
}
