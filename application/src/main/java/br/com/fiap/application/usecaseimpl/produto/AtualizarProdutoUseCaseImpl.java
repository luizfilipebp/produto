package br.com.fiap.application.usecaseimpl.produto;

import br.com.fiap.application.gateway.produto.AtualizarProdutoGateway;
import br.com.fiap.application.gateway.produto.BuscarProdutoGateway;
import br.com.fiap.core.model.Produto;
import br.com.fiap.usecase.produto.AtualizarProdutoUseCase;

public class AtualizarProdutoUseCaseImpl implements AtualizarProdutoUseCase {
    private final BuscarProdutoGateway produtoGateway;
    private final AtualizarProdutoGateway atualizarProdutoGateway;

    public AtualizarProdutoUseCaseImpl(BuscarProdutoGateway produtoGateway, AtualizarProdutoGateway atualizarProdutoGateway) {
        this.produtoGateway = produtoGateway;
        this.atualizarProdutoGateway = atualizarProdutoGateway;
    }

    @Override
    public Produto atualizar(Produto produto) {
        produtoGateway.buscar(produto.getId()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return atualizarProdutoGateway.atualizar(produto);
    }
}
