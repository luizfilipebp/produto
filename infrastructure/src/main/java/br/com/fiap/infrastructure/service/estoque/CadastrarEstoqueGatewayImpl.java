package br.com.fiap.infrastructure.service.estoque;

import br.com.fiap.application.gateway.estoque.CadastrarEstoqueGateway;
import br.com.fiap.core.model.Estoque;
import br.com.fiap.infrastructure.mapper.EstoqueMapper;
import br.com.fiap.infrastructure.repository.EstoqueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastrarEstoqueGatewayImpl implements CadastrarEstoqueGateway {

    private final EstoqueRepository repository;

    @Override
    public Estoque cadastrar(Estoque estoque) {
        return EstoqueMapper.INSTANCE.estoqueEntityToEstoque(repository.save(EstoqueMapper.INSTANCE.estoqueToEstoqueEntity(estoque)));
    }
}
