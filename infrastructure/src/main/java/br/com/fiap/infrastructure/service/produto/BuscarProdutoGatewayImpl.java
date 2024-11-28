package br.com.fiap.infrastructure.service.produto;

import br.com.fiap.application.gateway.produto.BuscarProdutoGateway;
import br.com.fiap.core.model.Produto;
import br.com.fiap.infrastructure.mapper.ProdutoMapper;
import br.com.fiap.infrastructure.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BuscarProdutoGatewayImpl implements BuscarProdutoGateway {

    private final ProdutoRepository produtoRepository;

    @Override
    public Optional<Produto> buscar(long id) {
        return produtoRepository.findById(id).map(ProdutoMapper.INSTANCE::produtoEntityToProduto);
    }
}
