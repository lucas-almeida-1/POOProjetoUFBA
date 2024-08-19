package Entidade.Produtos;

import Entidade.Item;

public class ProdutosFisicos extends Item {
    // Atributos
    private String descricao;

    // Construtor
    public ProdutosFisicos(String nome, String id, float preco, String descricao) {
        super(nome, id, preco, 1); // Chama o construtor da superclasse com a quantidade padrão de 1
        this.descricao = descricao;
    }

    // Métodos Get e Set
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ProdutosFisicos{" +
                "nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}