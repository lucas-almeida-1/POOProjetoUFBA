package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Screen extends JFrame {

    JLabel textload;

    public Screen() {

        // Janela
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

        // Sidebar - Canto esquerdo
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(44, 44, 44));
        sidebar.setBounds(0, 100, 300, 620);
        sidebar.setLayout(null);

        JButton LojaButton = new JButton("LOJA");
        LojaButton.setBounds(50, 50, 200, 50);
        LojaButton.setFont(new Font("Arial", Font.BOLD, 20));
        LojaButton.setForeground(new Color(245, 241, 241));
        LojaButton.setBackground(new Color(18, 17, 17));

        JButton BibliotecaButton = new JButton("BIBLIOTECA");
        BibliotecaButton.setBounds(50, 120, 200, 50);
        BibliotecaButton.setFont(new Font("Arial", Font.BOLD, 20));
        BibliotecaButton.setForeground(new Color(245, 241, 241));
        BibliotecaButton.setBackground(new Color(18, 17, 17));

        JButton PerfilButton = new JButton("PERFIL");
        PerfilButton.setBounds(50, 190, 200, 50);
        PerfilButton.setFont(new Font("Arial", Font.BOLD, 20));
        PerfilButton.setForeground(new Color(245, 241, 241));
        PerfilButton.setBackground(new Color(18, 17, 17));

        sidebar.add(LojaButton);
        sidebar.add(BibliotecaButton);
        sidebar.add(PerfilButton);

        // Main Content Area
        JPanel mainContent = new JPanel();
        mainContent.setBackground(new Color(24, 24, 24));
        mainContent.setBounds(300, 100, 980, 620);
        mainContent.setLayout(null);

        textload = new JLabel("Bem vindo ao Steam Verde"); // Jlabel texto de marcacao
        textload.setFont(new Font("Arial", Font.BOLD, 28));
        textload.setForeground(new Color(245, 241, 241));
        textload.setBounds(50, 50, 400, 50);


        mainContent.add(textload);



       //Botao Login + msg pos click
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(350, 310, 200, 70);
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setForeground(new Color(245, 241, 241));
        loginButton.setBackground(new Color(18, 17, 17));
        loginButton.addActionListener(e -> JOptionPane.showMessageDialog(null,
                "Login efetuado corretamente", "Login", JOptionPane.INFORMATION_MESSAGE));
        mainContent.add(loginButton);

        JTextField text = new JTextField("Digite o seu login"); // Caixa de texto login
        text.setBounds(50, 200, 500, 50);
        text.setFont(new Font("Arial", Font.ITALIC, 20));
        text.setForeground(new Color(41, 105, 50));
        mainContent.add(text);

        JTextField text2 = new JTextField("Digite a senha"); // Caixa de texto senha
        text2.setBounds(50, 255, 500, 50); // Posicao
        text2.setFont(new Font("Arial", Font.ITALIC, 20)); // Tipo da font
        text2.setForeground(new Color(41, 105, 50));
        mainContent.add(text2);

        // Adds da tela no frame
        add(header);
        add(sidebar);
        add(mainContent);

        setVisible(true);
    }

   private void outroteste (ActionEvent actionEvent) {

        textload.setText("Oi");

   }

}