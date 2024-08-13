package Screens;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    public Screen() {

        // Frame settings
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

        JButton homeButton = new JButton("LOJA");
        homeButton.setBounds(50, 50, 200, 50);
        homeButton.setFont(new Font("Arial", Font.BOLD, 20));
        homeButton.setForeground(new Color(245, 241, 241));
        homeButton.setBackground(new Color(18, 17, 17));

        JButton libraryButton = new JButton("BIBLIOTECA");
        libraryButton.setBounds(50, 120, 200, 50);
        libraryButton.setFont(new Font("Arial", Font.BOLD, 20));
        libraryButton.setForeground(new Color(245, 241, 241));
        libraryButton.setBackground(new Color(18, 17, 17));

        JButton storeButton = new JButton("PERFIL");
        storeButton.setBounds(50, 190, 200, 50);
        storeButton.setFont(new Font("Arial", Font.BOLD, 20));
        storeButton.setForeground(new Color(245, 241, 241));
        storeButton.setBackground(new Color(18, 17, 17));

        sidebar.add(homeButton);
        sidebar.add(libraryButton);
        sidebar.add(storeButton);

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

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(350, 300, 200, 70);
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setForeground(new Color(245, 241, 241));
        loginButton.setBackground(new Color(18, 17, 17));
        loginButton.addActionListener(e -> JOptionPane.showMessageDialog(null,
                "Login efetuado corretamente", "Login", JOptionPane.INFORMATION_MESSAGE));
        mainContent.add(loginButton);

        JTextField loginField = new JTextField("Digite o seu login");
        loginField.setBounds(50, 200, 500, 50);
        loginField.setFont(new Font("Arial", Font.ITALIC, 20));
        loginField.setForeground(new Color(41, 105, 50));
        mainContent.add(loginField);

        // Add panels to the frame
        add(header);
        add(sidebar);
        add(mainContent);

        setVisible(true);
    }


}