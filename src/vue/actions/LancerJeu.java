package vue.actions;

import java.awt.event.*;

import vue.CoreWar;

/** 
 * Classe représentant une action qui permet de lancer le jeu 
 *  à partir de la fênetre d'accueil
 * 
 * @author DOUMBOUYA Sekou <a href="mailto:sekou.doumbouya@etu.unicaen.fr"> sekou.doumbouya@etu.unicaen.fr </a>
 * @version 1.0
*/
public class LancerJeu implements ActionListener {

    /* Attributs de la classe */
    private CoreWar frame;

    /**
     * Constructeur de la classe
     * @param frame la fenetre du niveau supérieur avec la une bordure et une barre de titre
    */
    public LancerJeu(CoreWar frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.frame.setContentPane(frame.getEcranJeu());
        this.frame.validate();

    }

}
