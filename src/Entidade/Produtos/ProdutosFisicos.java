package Entidade.Produtos;

import Entidade.Item;

public class ProdutosFisicos extends Item {
    //Atributos
    private String descricao;

    //Construtor
    public ProdutosFisicos(String nome, String id, float preco, String descricao) {
        super(nome, id, preco);
        this.descricao = descricao;
    }

    //Métodos Get e Set
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
