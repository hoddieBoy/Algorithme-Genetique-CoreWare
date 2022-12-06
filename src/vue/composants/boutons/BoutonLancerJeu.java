package vue.composants.boutons;

import java.awt.Color;

import vue.CoreWar;
import vue.actions.LancerJeu;

/**
 * Classe représentant le button pour lancer le jeu
 * 
 * @author DOUMBOUYA Sekou <a href="mailto:sekou.doumbouya@etu.unicaen.fr"> sekou.doumbouya@etu.unicaen.fr </a>
 * @version 1.0
 */
public class BoutonLancerJeu extends AbstractBouton {

    /* Attribut de la classe */
    private CoreWar frame;

    /**
     * Constructeur de la classe
     * @param frame la fenetre du niveau supérieur avec la une bordure et une barre de titre (Lancer Jeu)
     * @param fondColor la couleur du fond
     */
    public BoutonLancerJeu(CoreWar frame, Color fondColor) {
        super("Lancer Jeu", fondColor);
        this.frame = frame;
    }

    @Override
    public void initialiserEvenements() {
        this.addActionListener(new LancerJeu(this.frame));

    }

}
