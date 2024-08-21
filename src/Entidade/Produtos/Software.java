package Entidade.Produtos;

import Entidade.Item;

public class Software extends Item {
    // Atributos
    private float tempoUso;

    // Construtor
    public Software(String nome, String id, float preco, float tempoUso) {
        super(nome, id, preco, 1); // Chama o construtor da superclasse com a quantidade padrão de 1
        this.tempoUso = tempoUso;
    }

    // Métodos Get e Set
    public float getTempoUso() {
        return tempoUso;
    }

    public void setTempoUso(float tempoUso) {
        this.tempoUso = tempoUso;
    }

    @Override
    public String toString() {
        return "Software{" +
                "nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                ", preco=" + preco +
                ", tempoUso=" + tempoUso +
                '}';
    }
}