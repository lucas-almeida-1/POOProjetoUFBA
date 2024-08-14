package Screens;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    public Screen() {

        // Frame config
        setTitle("Steam Verde");
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

        JLabel welcomeLabel = new JLabel("Bem vindo ao Steam Verde");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(245, 241, 241));
        welcomeLabel.setBounds(50, 50, 400, 50);
        mainContent.add(welcomeLabel);

       //Botao Login + msg pos click
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(350, 310, 200, 70);
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setForeground(new Color(245, 241, 241));
        loginButton.setBackground(new Color(18, 17, 17));
        loginButton.addActionListener(e -> JOptionPane.showMessageDialog(null,
                "Login efetuado corretamente", "Login", JOptionPane.INFORMATION_MESSAGE));
        mainContent.add(loginButton);

        JTextField text = new JTextField("Digite o seu login");
        text.setBounds(50, 200, 500, 50);
        text.setFont(new Font("Arial", Font.ITALIC, 20));
        text.setForeground(new Color(41, 105, 50));
        mainContent.add(text);

        JTextField text2 = new JTextField("Digite a senha");
        text2.setBounds(50, 255, 500, 50);
        text2.setFont(new Font("Arial", Font.ITALIC, 20));
        text2.setForeground(new Color(41, 105, 50));
        mainContent.add(text2);

        // Adds da tela
        add(header);
        add(sidebar);
        add(mainContent);

        setVisible(true);
    }


}