package ThreadInterface;

import javax.swing.*;
import java.awt.*;

public class TelaTimeThread extends JDialog /*pacote java / Framework para aplicações desktop, interfaces*/{

    private JPanel Jpanel = new JPanel(new GridBagLayout());// painel de componentes

    private JLabel descricaoHora = new JLabel("Time Thread 1");
    private JTextField mostraTempo = new JTextField();//campo de texto

    private JLabel descricaoHora2 = new JLabel("Time Thread 2");
    private JTextField mostraTempo2 = new JTextField(); //campo de texto

    private JButton jButton = new JButton("Start");//botões
    private JButton jButton2 = new JButton("Stop");

    public TelaTimeThread(){
        setTitle("Minha tela de TIme com Thread");
        setSize(new Dimension(240, 240));
        setLocationRelativeTo(null);
        setResizable(false);
        //primeira parte concluida


        //Controlador de posicionamentos de botões na tela
        GridBagConstraints gridBagConstraints = new GridBagConstraints();//gerenciador de layout
        gridBagConstraints.gridy = 0;//coluna
        gridBagConstraints.gridx = 0;//linha
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 10, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.WEST;


        descricaoHora.setPreferredSize(new Dimension(200, 25));// tamanho
        Jpanel.add(descricaoHora, gridBagConstraints);


        mostraTempo.setPreferredSize(new Dimension(200, 25));//tamanho
        gridBagConstraints.gridy++;//coluna
        mostraTempo.setEditable(false);
        Jpanel.add(mostraTempo, gridBagConstraints);


        descricaoHora2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        Jpanel.add(descricaoHora2, gridBagConstraints);


        mostraTempo2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;//coluna
        mostraTempo2.setEditable(false);
        Jpanel.add(mostraTempo2, gridBagConstraints);

        //***********************************

        gridBagConstraints.gridwidth = 1;

        jButton.setPreferredSize(new Dimension(95, 25));
        gridBagConstraints.gridy++;
        Jpanel.add(jButton, gridBagConstraints);

        jButton2.setPreferredSize(new Dimension(95, 25));
        gridBagConstraints.gridx++;
        Jpanel.add(jButton2, gridBagConstraints);


        add(Jpanel, BorderLayout.WEST);
        setVisible(true); /* Torna a tela visivel para o usuário,
        sempre será o ultimo comando */
    }

}
