package ThreadInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TelaTimeThread extends JDialog /*pacote java / Framework para aplicações desktop, interfaces*/{

    private JPanel Jpanel = new JPanel(new GridBagLayout());// painel de componentes

    private JLabel descricaoHora = new JLabel("Time Thread 1");
    private JTextField mostraTempo = new JTextField();//campo de texto

    private JLabel descricaoHora2 = new JLabel("Time Thread 2");
    private JTextField mostraTempo2 = new JTextField(); //campo de texto

    private JButton jButton = new JButton("Start");//botões
    private JButton jButton2 = new JButton("Stop");


    private Runnable thread1 = new Runnable() {
        @Override
        public void run() {
            while(true){// fica sempre rodando
                mostraTempo.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss")
                        .format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    };

    private Runnable thread2 = new Runnable() {
        @Override
        public void run() {
            while(true){
                mostraTempo2.setText(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
                        .format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    };

    private Thread thread1Time;
    private Thread thread2Time;


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

        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {//Executa o clique no botão
                thread1Time = new Thread(thread1);
                thread1Time.start();

                thread2Time = new Thread(thread2);
                thread2Time.start();

            }
        });

        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                thread1Time.stop();
                thread2Time.stop();
            }
        });


        add(Jpanel, BorderLayout.WEST);
        setVisible(true); /* Torna a tela visivel para o usuário,
        sempre será o ultimo comando */
    }

}
