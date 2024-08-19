package Screens;

import Entidade.Item;
import Entidade.Produtos.Compra.Carrinho;
import Entidade.Produtos.Compra.Pedido;
import Entidade.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class CarrinhoFrame extends JFrame {
    private Carrinho carrinho;
    private DefaultListModel<Item> itemListModel;
    private JList<Item> itemList;
    private JTextField itemNameField;
    private JTextField itemPriceField;
    private JTextField itemQuantityField;

    public CarrinhoFrame() {
        // Inicializa o carrinho com um usuário fictício
        Usuario usuario = new Usuario("rafael", "rafael123", "rafael123@gmail.com");
        carrinho = new Carrinho(usuario, UUID.randomUUID(), 10);

        // Configura a janela
        setTitle("Carrinho de Compras");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Cria o modelo da lista e a lista
        itemListModel = new DefaultListModel<>();
        itemList = new JList<>(itemListModel);
        add(new JScrollPane(itemList), BorderLayout.CENTER);

        // Painel para adicionar itens
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Nome do Item:"));
        itemNameField = new JTextField();
        inputPanel.add(itemNameField);

        inputPanel.add(new JLabel("Preço do Item:"));
        itemPriceField = new JTextField();
        inputPanel.add(itemPriceField);

        inputPanel.add(new JLabel("Quantidade:"));
        itemQuantityField = new JTextField();
        inputPanel.add(itemQuantityField);

        JButton addButton = new JButton("Adicionar Item");
        addButton.addActionListener(new AddItemAction());
        inputPanel.add(addButton);

        JButton orderButton = new JButton("Fazer Pedido");
        orderButton.addActionListener(new OrderAction());
        inputPanel.add(orderButton);

        add(inputPanel, BorderLayout.SOUTH);
    }


    private class AddItemAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = itemNameField.getText();
            float preco = Float.parseFloat(itemPriceField.getText());
            int quantidade = Integer.parseInt(itemQuantityField.getText());

            // Verifica se a quantidade é válida
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(CarrinhoFrame.this, "A quantidade deve ser maior que zero.");
                return;
            }

            // Cria um novo item com todos os parâmetros necessários
            Item novoItem = new Item(nome, UUID.randomUUID().toString(), preco, quantidade) {
                // Implementação anônima, se necessário
            };

            // Adiciona o item ao carrinho
            carrinho.addCarrinho(novoItem);
            itemListModel.addElement(novoItem); // Adiciona o item à lista da interface
            itemNameField.setText("");
            itemPriceField.setText("");
            itemQuantityField.setText("");
        }
    }
    // Ação para fazer o pedido
    private class OrderAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (carrinho.getQtdItens() > 0) {
                Pedido pedido = carrinho.fazerPedido(); // Faz o pedido
                JOptionPane.showMessageDialog(CarrinhoFrame.this, "Pedido feito com sucesso!");
            } else {
                JOptionPane.showMessageDialog(CarrinhoFrame.this, "O carrinho está vazio!");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarrinhoFrame frame = new CarrinhoFrame();
            frame.setVisible(true);
        });
    }

}