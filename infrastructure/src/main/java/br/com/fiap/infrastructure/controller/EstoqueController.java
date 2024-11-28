package br.com.fiap.infrastructure.controller;

import br.com.fiap.core.model.Estoque;
import br.com.fiap.infrastructure.dto.estoque.EstoquePostReqBody;
import br.com.fiap.infrastructure.dto.estoque.EstoquePutReqBody;
import br.com.fiap.infrastructure.mapper.EstoqueMapper;
import br.com.fiap.usecase.estoque.AtualizarEstoqueUseCase;
import br.com.fiap.usecase.estoque.BuscarEstoqueUseCase;
import br.com.fiap.usecase.estoque.CadastrarEstoqueUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/estoque")
public class EstoqueController {

   private final AtualizarEstoqueUseCase atualizarEstoque;
   private final BuscarEstoqueUseCase buscarEstoque;
   private final CadastrarEstoqueUseCase cadastrarEstoque;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPeloEstoque(@PathVariable Long id) {
        return ResponseEntity.ok().body(buscarEstoque.buscarPorId(id));
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<?> buscarPeloProduto(@PathVariable Long id) {
        return ResponseEntity.ok().body(buscarEstoque.buscarPorIdProduto(id));
    }

    @PostMapping()
    public ResponseEntity<?> cadastrarEstoque(@RequestBody EstoquePostReqBody req) {
        Estoque estoque = EstoqueMapper.INSTANCE.estoqueReqBodyToEstoque(req);
        return ResponseEntity.ok().body(cadastrarEstoque.cadastrar(estoque));
    }

    @PutMapping
    public  ResponseEntity<?> atualizarEstoque(@RequestBody EstoquePutReqBody req) {
        Estoque estoque = EstoqueMapper.INSTANCE.estoquePutReqBodyToEstoque(req);
        return ResponseEntity.ok().body(atualizarEstoque.atualizar(estoque));
    }
}
