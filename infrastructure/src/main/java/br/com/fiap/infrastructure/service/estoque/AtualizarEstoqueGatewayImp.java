package br.com.fiap.infrastructure.service.estoque;

import br.com.fiap.application.gateway.estoque.AtualizarEstoqueGateway;
import br.com.fiap.core.model.Estoque;
import br.com.fiap.infrastructure.mapper.EstoqueMapper;
import br.com.fiap.infrastructure.repository.EstoqueRepository;
import br.com.fiap.usecase.estoque.BuscarEstoqueUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarEstoqueGatewayImp implements AtualizarEstoqueGateway {

    private final BuscarEstoqueUseCase buscarEstoque;

    private final EstoqueRepository estoqueRepository;


    @Override
    public Estoque atualizar(Estoque estoque) {
        buscarEstoque.buscarPorId(estoque.getId()).orElseThrow(() -> new RuntimeException("Estoque não encontrado"));
        return EstoqueMapper.INSTANCE.estoqueEntityToEstoque(estoqueRepository.save(EstoqueMapper.INSTANCE.estoqueToEstoqueEntity(estoque)));
    }
}
