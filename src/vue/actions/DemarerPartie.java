package vue.actions;

import java.awt.event.*;


import javax.swing.*;

/**
 * Classe représentant une action permettant de démarrager la partie du jeu
 * 
 * @author DOUMBOUYA Sekou <a href="mailto:sekou.doumbouya@etu.unicaen.fr"> sekou.doumbouya@etu.unicaen.fr </a>
 * @version 1.0
 */

public class DemarerPartie implements ActionListener{

    /* Attributs de la classe */
    private Timer timer;
    
    /**
     * Constructeur de la classe
     * @param timer le temps de démarrage du jeu
     */
    public DemarerPartie(Timer timer) {
        this.timer = timer;
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        
    }
    
}
