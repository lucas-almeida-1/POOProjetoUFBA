package Screens;

import Entidade.Perfil;
import Entidade.Produtos.Jogos;
import Entidade.Produtos.ProdutosFisicos;
import Entidade.Produtos.Skin;
import Entidade.Produtos.Software;
import Entidade.Usuario;
import Entidade.Conquistas;
import Entidade.Item;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen2 extends JFrame {
    private Perfil perfil;  // classe Perfil definida com os métodos e atributos necessários

    public Screen2(Perfil perfil) {
        this.perfil = perfil;

        // Config da janela
        setTitle("Steam Verde Beta 1.0");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        // Header
        JPanel header = new JPanel();
        header.setBackground(new Color(41, 105, 50));
        header.setBounds(0, 0, 1280, 100);
        header.setLayout(null);
        JLabel title = new JLabel("Steam Verde");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(new Color(200, 200, 200));
        title.setBounds(20, 25, 300, 50);
        header.add(title);

        // Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(44, 44, 44));
        sidebar.setBounds(0, 100, 300, 620);
        sidebar.setLayout(null);

        // Botoes da barra lateral
        JButton apelidoButton = createSidebarButton("Mostrar Apelido", 50);
        JButton emailButton = createSidebarButton("Mostrar Email", 120);
        JButton usernameButton = createSidebarButton("Mostrar Username", 190);
        JButton amigosButton = createSidebarButton("Mostrar Amigos", 260);
        JButton conquistasButton = createSidebarButton("Conquistas", 330);
        JButton listButton = createSidebarButton("Lista de Desejos", 400);
        JButton exitButton = createSidebarButton("Sair", 470);

        sidebar.add(apelidoButton);
        sidebar.add(emailButton);
        sidebar.add(usernameButton);
        sidebar.add(amigosButton);
        sidebar.add(conquistasButton);
        sidebar.add(listButton);
        sidebar.add(exitButton);

        // Painel Principal
        JPanel mainContent = new JPanel();
        mainContent.setBackground(new Color(24, 24, 24));
        mainContent.setBounds(300, 100, 980, 620);
        mainContent.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 18));
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(new Color(24, 24, 24));
        mainContent.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Adicionando paineis ao Frame
        add(header);
        add(sidebar);
        add(mainContent);

        // Configurando ação dos botões
        apelidoButton.addActionListener(e -> textArea.setText("Seu apelido é " + perfil.getApelido()));
        emailButton.addActionListener(e -> textArea.setText("Seu email é " + perfil.getEmail()));
        usernameButton.addActionListener(e -> textArea.setText("Seu username é " + perfil.getUsername()));
        amigosButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("A sua lista de amigos é a seguinte:\n");
            for (Usuario amigo : perfil.getAmigos()) {
                sb.append(amigo.getUsername()).append("\n");
            }
            textArea.setText(sb.toString());
        });
        conquistasButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("A sua lista de conquistas é a seguinte:\n");
            for (Conquistas conquista : perfil.getConquistas()) {
                sb.append(conquista.getNomeConquista()).append("\n");
            }
            textArea.setText(sb.toString());
        });
        listButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("A sua lista de desejos é a seguinte:\n");
            for (Item item : perfil.getListaDeDesejos()) {
                sb.append(item.getNome()).append("\n");
            }
            textArea.setText(sb.toString());
        });
        exitButton.addActionListener(e -> System.exit(0));  // Fecha o programa

        setVisible(true);
    }

    private JButton createSidebarButton(String text, int y) { //JBotton geral
        JButton button = new JButton(text);
        button.setBounds(50, y, 220, 50);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setForeground(new Color(245, 241, 241));
        button.setBackground(new Color(18, 17, 17));
        return button;
    }

}