package br.com.fiap.application.usecaseimpl.produto;

import br.com.fiap.application.gateway.produto.BuscarProdutoGateway;
import br.com.fiap.application.gateway.produto.CadastrarProdutoGateway;
import br.com.fiap.core.model.Produto;
import br.com.fiap.usecase.produto.CadastrarProdutoUseCase;

public class CadastrarProdutoUseCaseImpl implements CadastrarProdutoUseCase {
    private final CadastrarProdutoGateway cadastrarProdutoGateway;
    private final BuscarProdutoGateway buscarProdutoGateway;

    public CadastrarProdutoUseCaseImpl(CadastrarProdutoGateway cadastrarProdutoGateway, BuscarProdutoGateway buscarProdutoGateway) {
        this.cadastrarProdutoGateway = cadastrarProdutoGateway;
        this.buscarProdutoGateway = buscarProdutoGateway;
    }

    @Override
    public Produto cadastrar(Produto produto) {
        buscarProdutoGateway.buscar(produto.getId()).ifPresent(p -> {
            throw new RuntimeException("Produto já cadastrado");
        });

        return cadastrarProdutoGateway.cadastrar(produto);
    }
}
