package br.com.fiap.infrastructure.mapper;

import br.com.fiap.core.model.Estoque;
import br.com.fiap.infrastructure.dto.estoque.EstoquePostReqBody;
import br.com.fiap.infrastructure.dto.estoque.EstoquePutReqBody;
import br.com.fiap.infrastructure.entity.EstoqueEntity;
import br.com.fiap.infrastructure.entity.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstoqueMapper {
    EstoqueMapper INSTANCE = Mappers.getMapper(EstoqueMapper.class);

    Estoque estoqueReqBodyToEstoque(EstoquePostReqBody estoqueReqBody);

    Estoque estoquePutReqBodyToEstoque(EstoquePutReqBody estoquePutReqBody);

    @Mapping(source = "produtoId", target = "produto.id")
    EstoqueEntity estoqueToEstoqueEntity(Estoque estoque);

    @Mapping(source = "produto.id", target = "produtoId")
    Estoque estoqueEntityToEstoque(EstoqueEntity estoqueEntity);


    default ProdutoEntity map(Long value) {
        if (value == null) {
            return null;
        }
        ProdutoEntity produto = new ProdutoEntity();
        produto.setId(value);
        return produto;
    }


}
