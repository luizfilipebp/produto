package br.com.fiap.core.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {
    private long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;

    public Produto(long id, String nome, String descricao, BigDecimal preco) {
        this.id = id;
        this.nome = validarNome(nome);
        this.descricao = validarDescricao(descricao);
        this.preco = validarPreco(preco);
    }

    private static BigDecimal validarPreco(BigDecimal preco) {
        if (preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        return preco;
    }

    private static String validarNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        return nome;
    }

    private static String validarDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia");
        }
        return descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
