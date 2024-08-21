package Entidade.Produtos.Compra;

import Entidade.Item;
import Entidade.Usuario;

import java.util.UUID;

public class Carrinho {
    private Usuario usuario;
    private UUID idcart;
    private Item[] itens;
    private int qtdItens;
    private float total;

    public Carrinho(Usuario usuario, UUID idcart, int capacidade) {
        this.usuario = usuario;
        this.idcart = idcart;
        this.itens = new Item[capacidade];
        this.qtdItens = 0;
        this.total = 0.0f;
    }

    public Carrinho() {
        this.itens = new Item[10]; // Capacidade padrão
        this.qtdItens = 0;
        this.total = 0.0f;
    }

    // Getters e Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UUID getIdcart() {
        return idcart;
    }

    public Item[] getItens() {
        return itens;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public float getTotal() {
        return total;
    }

    // Método para adicionar item ao carrinho
    public void addCarrinho(Item item) {
        if (item == null) {
            System.out.println("Erro: O item não pode ser nulo.");
            return; // Retorna se o item for nulo
        }
        if (qtdItens < itens.length) {
            itens[qtdItens] = item;
            qtdItens++;
            total += item.getPreco(); // Atualiza o total
        } else {
            System.out.println("Carrinho cheio! Não é possível adicionar mais itens.");
        }
    }


    // Método para atualizar a quantidade de um item
    public void atualizarQuantidadeItem(Item item, int quantidade) {
        for (int i = 0; i < qtdItens; i++) {
            if (itens[i].equals(item)) {
                total -= itens[i].getPreco() * itens[i].getQuantidade(); // Remove o preço atual
                itens[i].setQuantidade(quantidade); // Atualiza a quantidade
                total += itens[i].getPreco() * quantidade; // Atualiza o total
                break;
            }
        }
    }

    // Método para exibir detalhes do carrinho
    public boolean detalhesCarrinho() {
        System.out.println("Carrinho de compras: ");
        for (int i = 0; i < qtdItens; i++) {
            System.out.println("Item: " + itens[i].getNome() + " Preço: " + itens[i].getPreco() + " Quantidade: " + itens[i].getQuantidade());
        }
        System.out.println("Total: " + total);
        return true;
    }

    // Método para fazer um pedido
    public Pedido fazerPedido() {
        Pedido pedido = new Pedido(usuario, idcart, itens, qtdItens, total);
        return pedido;
    }
}