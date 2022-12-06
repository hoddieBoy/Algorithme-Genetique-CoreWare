package vue.composants.boutons;

import java.awt.Color;

import vue.CoreWar;
import vue.actions.DemarerPartie;


/**
 * Classe représentant le bouton pour jouer le jeu(CoreWar)
 * 
 * @author DOUMBOUYA Sekou <a href="mailto:sekou.doumbouya@etu.unicaen.fr"> sekou.doumbouya@etu.unicaen.fr </a>
 * @version 1.0
 */

public class BoutonJouer extends AbstractBouton{

    /**Fenetre associer au bouton */
    private CoreWar frame;

    /**
     * Constructeur de la classe
     * @param fondColor la couleur du fond
     * @param frame la fenetre du niveau supérieur avec la une bordure et une barre de titre (Jouer)
     */
    public BoutonJouer(Color fondColor, CoreWar frame) {
        super("Jouer", fondColor);
        this.frame = frame;
    }

    @Override
    public void initialiserEvenements() {
        this.addActionListener(new DemarerPartie(frame.getTimer()));
    }



    
    
}
