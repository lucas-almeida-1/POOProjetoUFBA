package Entidade.Produtos;

import Entidade.Item;
import Entidade.Produtos.Jogos;

public class Skin extends Item {
    // Atributos
    private Jogos jogoRelacionado;
    private String descricao;

    // Construtor
    public Skin(String nome, String id, float preco, Jogos jogoRelacionado, String descricao) {
        super(nome, id, preco, 1); // Chama o construtor da superclasse com a quantidade padrão de 1
        this.jogoRelacionado = jogoRelacionado;
        this.descricao = descricao;
    }

    // Métodos Gerais
    public void reembolso() {
        // Toda construção do código para o reembolso
    }

    // Métodos Get e Set
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

    @Override
    public String toString() {
        return "Skin{" +
                "nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                ", preco=" + preco +
                ", jogoRelacionado=" + jogoRelacionado +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}