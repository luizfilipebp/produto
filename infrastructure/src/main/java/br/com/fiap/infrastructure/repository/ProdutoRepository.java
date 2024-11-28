package br.com.fiap.infrastructure.repository;

import br.com.fiap.infrastructure.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
