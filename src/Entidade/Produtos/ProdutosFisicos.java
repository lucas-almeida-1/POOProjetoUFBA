package Entidade.Produtos;

import Entidade.Item;

public class ProdutosFisicos extends Item {
    //Atributos
    private String descricao;
    private String tamanho;

    //Construtor
    public ProdutosFisicos(String nome, String id, float preco, String descricao, String tamanho) {
        super(nome, id, preco);
        this.descricao = descricao;
        this.tamanho = tamanho;
    }

    //Métodos Get e Set
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
