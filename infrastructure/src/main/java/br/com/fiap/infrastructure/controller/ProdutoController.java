package br.com.fiap.infrastructure.controller;

import br.com.fiap.core.model.Produto;
import br.com.fiap.infrastructure.dto.produto.ProdutoPostReqBody;
import br.com.fiap.infrastructure.dto.produto.ProdutoPutReqBody;
import br.com.fiap.infrastructure.mapper.ProdutoMapper;
import br.com.fiap.usecase.produto.AtualizarProdutoUseCase;
import br.com.fiap.usecase.produto.BuscarProdutoUseCase;
import br.com.fiap.usecase.produto.CadastrarProdutoUseCase;
import br.com.fiap.usecase.produto.ExcluirProdutoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/produto")
public class ProdutoController {

    private final AtualizarProdutoUseCase atualizarProdutoUseCase;
    private final BuscarProdutoUseCase buscarProdutoUseCase;
    private final CadastrarProdutoUseCase cadastrarProdutoUseCase;
    private final ExcluirProdutoUseCase excluirProdutoUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id) {
        return ResponseEntity.ok().body(buscarProdutoUseCase.buscarPorId(id));
    }

    @PutMapping()
    public ResponseEntity<?> atualizarProduto(@RequestBody ProdutoPutReqBody req) {
        Produto produto = ProdutoMapper.INSTANCE.produtoPutReqBodyToProduto(req);
        return ResponseEntity.ok().body(atualizarProdutoUseCase.atualizar(produto));
    }

    @PostMapping()
    public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoPostReqBody req) {
        Produto produto = ProdutoMapper.INSTANCE.produtoPostReqBodyToProduto(req);
        return ResponseEntity.ok().body(cadastrarProdutoUseCase.cadastrar(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable Long id) {
        excluirProdutoUseCase.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
