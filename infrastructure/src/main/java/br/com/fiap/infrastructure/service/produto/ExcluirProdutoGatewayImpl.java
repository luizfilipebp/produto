package br.com.fiap.infrastructure.service.produto;

import br.com.fiap.application.gateway.produto.ExcluirProdutoGateway;
import br.com.fiap.infrastructure.entity.ProdutoEntity;
import br.com.fiap.infrastructure.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ExcluirProdutoGatewayImpl implements ExcluirProdutoGateway {
    private final ProdutoRepository produtoRepository;

    @Override
    public void excluir(long id) {
        Optional<ProdutoEntity> byId = produtoRepository.findById(id);
        byId.ifPresent(produtoRepository::delete);
    }
}
