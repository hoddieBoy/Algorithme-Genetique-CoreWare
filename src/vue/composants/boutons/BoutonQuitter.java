package vue.composants.boutons;

import java.awt.Color;

import vue.CoreWar;
import vue.actions.QuitterPartie;

/**
 * Classe représentant le boutton pour quitter le jeu
 * 
 * @author DOUMBOUYA Sekou <a href="mailto:sekou.doumbouya@etu.unicaen.fr"> sekou.doumbouya@etu.unicaen.fr </a>
 * @version 1.0
 */
public class BoutonQuitter extends AbstractBouton{

    /* Attributs de la classe  */
    private CoreWar frame;

    /**
     * Constructeur de la classe
     * @param fondColor la couleur du fond 
     * @param frame la fenetre du niveau supérieur avec la une bordure et une barre de titre (Quitter)
     */
    public BoutonQuitter(Color fondColor, CoreWar frame) {
        super("Quitter", fondColor);
        this.frame = frame;
        //TODO Auto-generated constructor stub
    }

    @Override
    public void initialiserEvenements() {
        addActionListener(new QuitterPartie(frame));
    }

    
}
