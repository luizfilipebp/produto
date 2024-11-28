package br.com.fiap.infrastructure.mapper;

import br.com.fiap.core.model.Produto;
import br.com.fiap.infrastructure.dto.produto.ProdutoPostReqBody;
import br.com.fiap.infrastructure.dto.produto.ProdutoPutReqBody;
import br.com.fiap.infrastructure.entity.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    Produto produtoEntityToProduto(ProdutoEntity produtoEntity);

    ProdutoEntity produtoToProdutoEntity(Produto produto);

    Produto produtoPutReqBodyToProduto(ProdutoPutReqBody produtoPutReqBody);

    Produto produtoPostReqBodyToProduto(ProdutoPostReqBody produtoPutReqBody);
}
