package Entidade.Produtos;

import Entidade.Item;

public class Jogos extends Item {
    //Atributos
    protected float tempoUso;
    protected boolean temConquista;

    //Construtor
    public Jogos(String nome, String id, float preco, float tempoUso, boolean temConquista) {
        super(nome, id, preco);
        this.tempoUso = tempoUso;
        this.temConquista = temConquista;
    }

    //Método Get e Set
    public float getTempoUso() {
        return tempoUso;
    }

    public void setTempoUso(float tempoUso) {
        this.tempoUso = tempoUso;
    }

    public boolean isTemConquista() {
        return temConquista;
    }

    public void setTemConquista(boolean temConquista) {
        this.temConquista = temConquista;
    }
}
