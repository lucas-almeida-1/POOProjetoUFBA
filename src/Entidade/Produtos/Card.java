package Entidade.Produtos;

import Entidade.Item;

public class Card extends Item {
    // Atributos
    private Item itemRelacionado;

    // Construtor
    public Card(String nome, String id, float preco, Item itemRelacionado) {
        super(nome, id, preco, 1); // Chama o construtor da superclasse com a quantidade padrão de 1
        this.itemRelacionado = itemRelacionado;
    }

    // Métodos Get e Set
    public Item getItemRelacionado() {
        return this.itemRelacionado;
    }

    public void setItemRelacionado(Item itemRelacionado) {
        this.itemRelacionado = itemRelacionado;
    }

    @Override
    public String toString() {
        return "Card{" +
                "nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                ", preco=" + preco +
                ", itemRelacionado=" + itemRelacionado.getNome() + // Exibe o nome do item relacionado
                '}';
    }
}