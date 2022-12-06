package vue.actions;

import java.awt.event.*;

import javax.swing.Timer;

/**
 * Classe representtant une action permettant
 * de faire une pause lors de la partie du jeu
 * 
 * @author DOUMBOUYA Sekou <a href="mailto:sekou.doumbouya@etu.unicaen.fr"> sekou.doumbouya@etu.unicaen.fr </a>
 * @version 1.0
 */
public class PausePartie implements ActionListener{

    /* Attribut de la classe */
    private Timer timer;
    
    /**
     * Constructeur de la classe
     * @param timer le temps de pause
     */
    public PausePartie(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.timer.stop();
    }
    
}
