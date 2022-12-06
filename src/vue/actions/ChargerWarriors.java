package vue.actions;

import java.awt.event.*;

import controleur.Controleur;

/**
 * Classe representant une action permettant de charger 
 * les warriors(les guerriers ou les combattants) du jeu
 * 
 * @author DOUMBOUYA Sekou <a href="mailto:sekou.doumbouya@etu.unicaen.fr"> sekou.doumbouya@etu.unicaen.fr </a>
 * @version 1.0
 */

public class ChargerWarriors implements ActionListener{

    /* Attributs de la classe */
    private Controleur controleur;

    /**
     * Constructeur de la classe
     * @param controleur le controleur du jeu
     */
    public ChargerWarriors(Controleur controleur) {
        this.controleur = controleur;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        controleur.setTour(0);
        controleur.chargementWarriors();
        controleur.setTour(0);
        controleur.setScore1(0);
        controleur.setScore2(0);

    }
    
}
