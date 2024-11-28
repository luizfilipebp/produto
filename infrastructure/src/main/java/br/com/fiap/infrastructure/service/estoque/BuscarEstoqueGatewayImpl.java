package br.com.fiap.infrastructure.service.estoque;

import br.com.fiap.application.gateway.estoque.BuscarEstoqueGateway;
import br.com.fiap.core.model.Estoque;
import br.com.fiap.infrastructure.mapper.EstoqueMapper;
import br.com.fiap.infrastructure.repository.EstoqueRepository;
import br.com.fiap.infrastructure.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BuscarEstoqueGatewayImpl implements BuscarEstoqueGateway {

    private final EstoqueRepository estoqueRepository;

    private final ProdutoRepository produtoRepository;

    @Override
    public Optional<Estoque> buscarPorId(Long id) {
        return estoqueRepository.findById(id).map(EstoqueMapper.INSTANCE::estoqueEntityToEstoque);
    }

    @Override
    public Optional<Estoque> buscarPorIdProduto(Long id) throws RuntimeException {
        // Verifica se o produto existe
        produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return estoqueRepository.findByProdutoId(id).map(EstoqueMapper.INSTANCE::estoqueEntityToEstoque);
    }
}
