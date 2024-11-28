package br.com.fiap.infrastructure.repository;

import br.com.fiap.infrastructure.entity.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Long> {

    Optional<EstoqueEntity> findByProdutoId(Long produto_id);
}
