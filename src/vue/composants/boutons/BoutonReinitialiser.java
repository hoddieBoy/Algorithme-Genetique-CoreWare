package vue.composants.boutons;

import java.awt.Color;

import controleur.Controleur;
import vue.actions.Reinitialiser;


/**
 * Classe représentant le bouton de réinitialisation du jeu
 */
public class BoutonReinitialiser extends AbstractBouton{

    private Controleur controleur;
    /**
     * Constructeur de la classe
     * @param fondColor la couleur du fond de l'écran
     */
    public BoutonReinitialiser(Color fondColor, Controleur controleur) {
        super("Reinitialiser", fondColor);
        this.controleur = controleur;
    }

    @Override
    public void initialiserEvenements() {
        this.addActionListener(new Reinitialiser(controleur));
    }
    
    
}
