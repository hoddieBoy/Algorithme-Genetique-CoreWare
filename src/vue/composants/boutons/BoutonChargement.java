package vue.composants.boutons;

import java.awt.Color;


import controleur.Controleur;
import vue.actions.ChargerWarriors;

/**
 * Classe représentant le bouton pour le chargement du jeu (CoreWar)
 * 
 * @author DOUMBOUYA Sekou <a href="mailto:sekou.doumbouya@etu.unicaen.fr"> sekou.doumbouya@etu.unicaen.fr </a>
 * @version 1.0
 */

public class BoutonChargement extends AbstractBouton{

    /**Un controleur qui interagit avec le bouton */
    private Controleur controleur;

    /**
     * Constructeur de la classe 
     * @param fondColor la couleur du fond
     * @param controleur le controleur qui interagit avec le bouton
     */
    public BoutonChargement(Color fondColor, Controleur controleur) {
        super("Chargement", fondColor);
        this.controleur = controleur;
    }
    @Override
    public void initialiserEvenements() {
        addActionListener(new ChargerWarriors(controleur));
    }

    
    
    
    
}
