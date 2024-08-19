package Entidade.Produtos;

import Entidade.Item;

public class Jogos extends Item {
    private int duracao; // Duração do jogo em horas
    private boolean online; // Indica se o jogo é online

    // Construtor
    public Jogos(String nome, String id, float preco, int duracao, boolean online) {
        super(nome, id, preco, 1); // Chama o construtor da superclasse com a quantidade padrão de 1
        this.duracao = duracao;
        this.online = online;
    }

    // Getters e Setters
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "Jogos{" +
                "nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                ", preco=" + preco +
                ", duracao=" + duracao +
                ", online=" + online +
                '}';
    }
}