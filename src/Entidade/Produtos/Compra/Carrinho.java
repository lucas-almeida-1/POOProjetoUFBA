package Entidade.Produtos.Compra;

import Entidade.Item;
import Entidade.Produtos.Jogos;
import Entidade.Usuario;
import Entidade.Produtos.Compra.Pedido;
import java.util.UUID;
// UUI4
public class Carrinho {
    // UUI4
    private Usuario usuario;
    private UUID idcart;
    // Lista de todos itens e classes descendentes de item como Jogos, Card, ProdutosFisicos, Skin, Software, Soudtrack
    private Item[] itens;
    private int qtdItens ;
    private float total;

    public Carrinho(Usuario usuario, UUID idcart, Item[] itens, int qtdItens, float total) {
        this.usuario = usuario;
        this.idcart = UUID.randomUUID();
        this.itens = itens;
        this.qtdItens = qtdItens;
        this.total = total;
    }

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

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    // MÉTODO ADD CARRINHO
    public void addCarrinho(Item item){
        if (qtdItens < itens.length){
            itens[qtdItens] = item;
            qtdItens++;
            total += item.getPreco();
        }
    }
    // ATUALIZAR QUANTIDADE ITEM
    public void atualizarQuantidadeItem(Item item, int quantidade){
        for (int i = 0; i < qtdItens; i++){
            if (itens[i].equals(item)){
                total -= itens[i].getPreco();
                itens[i].setPreco(quantidade);
                total += itens[i].getPreco();
            }
        }
    }
    // DETALHES DO CARRINHO
    public void detalhesCarrinho(){
        System.out.println("Carrinho de compras: ");
        for (int i = 0; i < qtdItens; i++){
            System.out.println("Item: " + itens[i].getNome() + " Preço: " + itens[i].getPreco());
        }
        System.out.println("Total: " + total);
    }
    // Fazer pedido

}
