package ThreadInterface;

import Fila.ImplementacaoFilaThread;
import Fila.ObjetoFilaThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaTimeThread extends JDialog /*pacote java / Framework para aplicações desktop, interfaces*/{

    private JPanel Jpanel = new JPanel(new GridBagLayout());// painel de componentes

    private JLabel descricaoHora = new JLabel("Nome");
    private JTextField mostraTempo = new JTextField();//campo de texto

    private JLabel descricaoHora2 = new JLabel("E-mail");
    private JTextField mostraTempo2 = new JTextField(); //campo de texto

    private JButton jButton = new JButton("Add Lista");//botões
    private JButton jButton2 = new JButton("Stop");

    private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

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
        Jpanel.add(mostraTempo, gridBagConstraints);


        descricaoHora2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        Jpanel.add(descricaoHora2, gridBagConstraints);


        mostraTempo2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;//coluna
        Jpanel.add(mostraTempo2, gridBagConstraints);

        //***********************************

        gridBagConstraints.gridwidth = 1;

        jButton.setPreferredSize(new Dimension(95, 25));
        gridBagConstraints.gridy++;
        Jpanel.add(jButton, gridBagConstraints);

        jButton2.setPreferredSize(new Dimension(95, 25));
        gridBagConstraints.gridx++;
        Jpanel.add(jButton2, gridBagConstraints);

        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {//Executa o clique no botão
                ObjetoFilaThread filaThread = new ObjetoFilaThread();
                filaThread.setNome(mostraTempo.getText());
                filaThread.setEmail(mostraTempo2.getText());

                fila.add(filaThread);

            }
        });

        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });


        fila.start();
        add(Jpanel, BorderLayout.WEST);
        setVisible(true); /* Torna a tela visivel para o usuário,
        sempre será o ultimo comando */
    }

}
