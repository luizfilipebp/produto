package br.com.fiap.infrastructure.service.produto;

import br.com.fiap.application.gateway.produto.AtualizarProdutoGateway;
import br.com.fiap.core.model.Produto;
import br.com.fiap.infrastructure.mapper.ProdutoMapper;
import br.com.fiap.infrastructure.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtualizarProdutoGatewayImpl implements AtualizarProdutoGateway {

    private final ProdutoRepository produtoRepository;

    @Override
    public Produto atualizar(Produto produto) {
        return ProdutoMapper.INSTANCE.produtoEntityToProduto(produtoRepository.save(ProdutoMapper.INSTANCE.produtoToProdutoEntity(produto)));
    }
}
