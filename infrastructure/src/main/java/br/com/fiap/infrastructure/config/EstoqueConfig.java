package br.com.fiap.infrastructure.config;

import br.com.fiap.application.gateway.estoque.AtualizarEstoqueGateway;
import br.com.fiap.application.gateway.estoque.BuscarEstoqueGateway;
import br.com.fiap.application.gateway.estoque.CadastrarEstoqueGateway;
import br.com.fiap.application.usecaseimpl.estoque.AtualizarEstoqueUseCaseImpl;
import br.com.fiap.application.usecaseimpl.estoque.BuscarEstoqueUseCaseImpl;
import br.com.fiap.application.usecaseimpl.estoque.CadastrarEstoqueUseCaseImpl;
import br.com.fiap.usecase.estoque.AtualizarEstoqueUseCase;
import br.com.fiap.usecase.estoque.BuscarEstoqueUseCase;
import br.com.fiap.usecase.estoque.CadastrarEstoqueUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstoqueConfig {
    @Bean
    AtualizarEstoqueUseCase atualizarEstoque(BuscarEstoqueGateway buscarEstoqueGateway, AtualizarEstoqueGateway atualizarEstoqueGateway) {
        return new AtualizarEstoqueUseCaseImpl(buscarEstoqueGateway, atualizarEstoqueGateway);
    }

    @Bean
    BuscarEstoqueUseCase buscarEstoque(BuscarEstoqueGateway buscarEstoqueGateway) {
        return new BuscarEstoqueUseCaseImpl(buscarEstoqueGateway);
    }

    @Bean
    CadastrarEstoqueUseCase cadastrarEstoque(CadastrarEstoqueGateway cadastrarEstoqueGateway) {
        return new CadastrarEstoqueUseCaseImpl(cadastrarEstoqueGateway);
    }
}
