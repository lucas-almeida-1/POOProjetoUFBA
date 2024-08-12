package Entidade.Produtos;

import Entidade.Item;

public class Skin extends Item {
    //Atributos
    private Jogos jogoRelacionado;
    private String descricao;

    //Construtor
    public Skin(String nome, String id, float preco, Jogos jogoRelacionado, String descricao) {
        super(nome, id, preco);
        this.jogoRelacionado = jogoRelacionado;
        this.descricao = descricao;
    }

    //Métodos Gerais
    public void reembolso(){
        // toda construção do código para o reembolso
    }

    //Métodos Get e Set
    public Jogos getJogoRelacionado() {
        return this.jogoRelacionado;
    }

    public void setJogoRelacionado(Jogos jogoRelacionado) {
        this.jogoRelacionado = jogoRelacionado;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
