package Entidade;

import Entidade.Produtos.Jogos;

public class Conquistas {
    //Atributos
    private String nomeConquista;
    private String descricao;
    private Jogos jogoRelacionado;

    //Construtor
    public Conquistas(String nomeConquista, String descricao, Jogos jogoRelacionado) {
        this.nomeConquista = nomeConquista;
        this.descricao = descricao;
        this.jogoRelacionado = jogoRelacionado;
    }

    //Métodos Get e Set
    public String getNomeConquista() {
        return nomeConquista;
    }

    public void setNomeConquista(String nomeConquista) {
        this.nomeConquista = nomeConquista;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Jogos getJogoRelacionado() {
        return jogoRelacionado;
    }

    public void setJogoRelacionado(Jogos jogoRelacionado) {
        this.jogoRelacionado = jogoRelacionado;
    }
}
