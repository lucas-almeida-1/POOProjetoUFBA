package Entidade.Produtos;

import Entidade.Item;

public class Software extends Item {
    //Atributos
    private float tempoUso;

    //Construtor
    public Software(String nome, String id, float preco, float tempoUso) {
        super(nome, id, preco);
        this.tempoUso = tempoUso;
    }

    //Método Get e Set
    public float getTempoUso() {
        return tempoUso;
    }

    public void setTempoUso(float tempoUso) {
        this.tempoUso = tempoUso;
    }
}
