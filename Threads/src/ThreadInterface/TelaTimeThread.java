package ThreadInterface;

import javax.swing.*;
import java.awt.*;

public class TelaTimeThread extends JDialog /*pacote java / Framework para aplicações desktop, interfaces*/{

    public TelaTimeThread(){
        setTitle("Minha tela de TIme com Thread");
        setSize(new Dimension(240, 240));
        setLocationRelativeTo(null);
        setResizable(false);
        //primeira parte concluida

        



        setVisible(true); /* Torna a tela visivel para o usuário,
        sempre será o ultimo comando */
    }

}
