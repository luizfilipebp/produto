package br.com.fiap.core.model;

import java.util.Objects;

public class Estoque {
    private long id;
    private long produtoId;
    private int quantidade;

    public Estoque(long id, long produtoId, int quantidade) {
        this.id = id;
        this.produtoId = produtoId;
        this.quantidade = validarQuantidade(quantidade);
    }

    private static int validarQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        return quantidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(long produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return id == estoque.id && produtoId == estoque.produtoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, produtoId);
    }
}
