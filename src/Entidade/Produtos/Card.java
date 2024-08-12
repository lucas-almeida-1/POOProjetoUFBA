package Entidade.Produtos;

import Entidade.Item;

public class Card extends Item {
    //Atributos
    private Item itemRelacionado;

    //Construtor
    public Card(String nome, String id, float preco, Item itemRelacionado){
        super(nome, id, preco);
        this.itemRelacionado = itemRelacionado;
    }

    //Métodos Get e Set
    public Item getItemRelacionado() {
        return this.itemRelacionado;
    }

    public void setItemRelacionado(Item itemRelacionado) {
        this.itemRelacionado = itemRelacionado;
    }
}
