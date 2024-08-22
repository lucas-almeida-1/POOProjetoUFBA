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

public class Screen3 extends JFrame {
    private Perfil perfil;

    public Screen3(Perfil perfil) {
        this.perfil = perfil;


        // Configurações da janela
        setTitle("Steam Verde Beta 1.0");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Head
        JPanel header = new JPanel();
        header.setBackground(new Color(41, 105, 50));
        header.setPreferredSize(new Dimension(1280, 60));
        header.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel title = new JLabel("Biblioteca de Jogos");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(new Color(255, 255, 255));
        header.add(title);

        // Seach (JTextField)
        JTextField searchField = new JTextField(30); // Tamanho do campo de texto
        searchField.setFont(new Font("Arial", Font.PLAIN, 20));
        searchField.setForeground(Color.BLACK);
        searchField.setBackground(Color.WHITE);
        header.add(searchField);

        //Botao voltar
        JButton backButton = new JButton("Voltar");
        backButton.setBounds(1020, 10, 150, 35);
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setForeground(new Color(245, 241, 241));
        backButton.setBackground(new Color(18, 17, 17));
        backButton.addActionListener(e -> {
            new Screen(perfil);
            dispose();  // Fecha a tela atual
        });
        add(backButton);

        // Área das capas jogos (conteúdo principal)
        JPanel content = new JPanel();
        content.setBackground(new Color(24, 24, 24));
        content.setLayout(new GridLayout(3, 4, 10, 10)); // 3 linhas, 4 colunas, com espaçamento de 10px

        // String para imagens capas
        String[] imagePaths = {
                "C:/Users/Thales/OneDrive/Imagens/capas/Elden_Ring.jpg",
                "C:/Users/Thales/OneDrive/Imagens/capas/Cs_2.jpg",
                "C:/Users/Thales/OneDrive/Imagens/capas/Resident_Evil4_Remake.jpg",
                "C:/Users/Thales/OneDrive/Imagens/capas/Lenda_Heroi.jpg",
                "C:/Users/Thales/OneDrive/Imagens/capas/TheLastOfUs.jpg",
                "C:/Users/Thales/OneDrive/Imagens/capas/Hollow_Knight.jpg",
                "C:/Users/Thales/OneDrive/Imagens/capas/League_Of_Legends.jpg",
                "C:/Users/Thales/OneDrive/Imagens/capas/Valorant.jpg",
                "C:/Users/Thales/OneDrive/Imagens/capas/Minecraft.jpg",
                "C:/Users/Thales/OneDrive/Imagens/capas/Elypse.jpg",
                "C:/Users/Thales/OneDrive/Imagens/capas/Hades.jpg",
                "C:/Users/Thales/OneDrive/Imagens/capas/Zomboid.jpg"
        };


        // Adicionando botton com imagens
        for (String imagePath : imagePaths) {
            JButton imageButton = createImageButton(imagePath);
            content.add(imageButton);
        }

        // Adicionando ao frame
        add(header, BorderLayout.NORTH);
        add(new JScrollPane(content), BorderLayout.CENTER);

        setVisible(true);
    }

    // Método  botoes com imagens
    private JButton createImageButton(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath); // Carrega a imagem
        JButton button = new JButton(imageIcon); // Define a imagem como ícone do botão
        button.setPreferredSize(new Dimension(200, 300)); // Define o tamanho do botão
        button.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda do botão
        button.setContentAreaFilled(false); // Remove o fundo do botão

        // action listener para quando a imagem for clicada
        button.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,  "ID:Teste \n" + "Info do Jogo:@@@ \n " +
                "Update:@@@ \n ");

            }
        });

        return button;


    }
}