package br.com.fiap.infrastructure.config;

import br.com.fiap.application.gateway.produto.AtualizarProdutoGateway;
import br.com.fiap.application.gateway.produto.BuscarProdutoGateway;
import br.com.fiap.application.gateway.produto.CadastrarProdutoGateway;
import br.com.fiap.application.gateway.produto.ExcluirProdutoGateway;
import br.com.fiap.application.usecaseimpl.produto.AtualizarProdutoUseCaseImpl;
import br.com.fiap.application.usecaseimpl.produto.BuscarProdutoUseCaseImpl;
import br.com.fiap.application.usecaseimpl.produto.CadastrarProdutoUseCaseImpl;
import br.com.fiap.application.usecaseimpl.produto.ExcluirProdutoUseCaseImpl;
import br.com.fiap.usecase.produto.AtualizarProdutoUseCase;
import br.com.fiap.usecase.produto.BuscarProdutoUseCase;
import br.com.fiap.usecase.produto.CadastrarProdutoUseCase;
import br.com.fiap.usecase.produto.ExcluirProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoConfig {
    @Bean
    AtualizarProdutoUseCase atualizarProdutoUseCase(BuscarProdutoGateway buscarProdutoGateway, AtualizarProdutoGateway atualizarProdutoGateway) {
        return new AtualizarProdutoUseCaseImpl(buscarProdutoGateway, atualizarProdutoGateway);
    }

    @Bean
    BuscarProdutoUseCase buscarProdutoUseCase(BuscarProdutoGateway buscarProdutoGateway) {
        return new BuscarProdutoUseCaseImpl(buscarProdutoGateway);

    }

    @Bean
    CadastrarProdutoUseCase cadastrarProdutoUseCase(CadastrarProdutoGateway produtoGateway, BuscarProdutoGateway buscarProdutoGateway) {
        return new CadastrarProdutoUseCaseImpl(produtoGateway, buscarProdutoGateway);
    }

    @Bean
    ExcluirProdutoUseCase excluirProdutoUseCase(BuscarProdutoGateway buscarProdutoGateway, ExcluirProdutoGateway excluirProdutoGateway) {
        return new ExcluirProdutoUseCaseImpl(buscarProdutoGateway, excluirProdutoGateway);
    }
}
