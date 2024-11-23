package br.com.fiap.application.usecaseimpl.produto;

import br.com.fiap.application.gateway.produto.BuscarProdutoGateway;
import br.com.fiap.application.gateway.produto.ExcluirProdutoGateway;
import br.com.fiap.produto.ExcluirProdutoUseCase;

public class ExcluirProdutoUseCaseImpl implements ExcluirProdutoUseCase {
    private final BuscarProdutoGateway buscarProdutoGateway;
    private final ExcluirProdutoGateway excluirProdutoGateway;

    public ExcluirProdutoUseCaseImpl(BuscarProdutoGateway buscarProdutoGateway, ExcluirProdutoGateway excluirProdutoGateway) {
        this.buscarProdutoGateway = buscarProdutoGateway;
        this.excluirProdutoGateway = excluirProdutoGateway;
    }

    @Override
    public void excluir(Long id) {
        buscarProdutoGateway.buscar(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        excluirProdutoGateway.excluir(id);
    }
}
