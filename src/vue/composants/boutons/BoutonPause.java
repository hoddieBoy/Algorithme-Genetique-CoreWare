package vue.composants.boutons;

import java.awt.Color;

import vue.CoreWar;
import vue.actions.PausePartie;

/**
 * Classe représentant le boutton de pause (stopper le jeu)
 * 
 * @author DOUMBOUYA Sekou <a href="mailto:sekou.doumbouya@etu.unicaen.fr"> sekou.doumbouya@etu.unicaen.fr </a>
 * @version 1.0
 */
public class BoutonPause extends AbstractBouton{

    /* Attribut de la classe */
    private CoreWar frame;

    /**
     * Constructeur de la classe
     * @param fondColor la couleur du fond
     * @param frame la fenetre du niveau supérieur avec la une bordure et une barre de titre (Pause)
     */
    public BoutonPause(Color fondColor, CoreWar frame) {
        super("Pause", fondColor);
        this.frame = frame;
    }

    @Override
    public void initialiserEvenements() {

        addActionListener(new PausePartie(frame.getTimer()));
    }

    
}
