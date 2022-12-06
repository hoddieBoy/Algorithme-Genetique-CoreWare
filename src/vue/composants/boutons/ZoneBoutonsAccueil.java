package vue.composants.boutons;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;

import vue.CoreWar;

/**
 * Classe représentant les boutons de la zone d'accueil
 */
public class ZoneBoutonsAccueil extends AbstractZoneBouton {

    private BoutonLancerJeu lancerJeu; /** Le bouton pour lancer de jeu */

    private BoutonQuitter quitterJeu; /** Le bouton pour  quitter le jeu */

    /** 
     * Constructeur de la classe 
     * @param fenetre la fenetre de la zone d'accueil
    */
    public ZoneBoutonsAccueil(CoreWar fenetre) {
        super(fenetre);
        this.lancerJeu = new BoutonLancerJeu(this.ecran, Color.GREEN);
        this.quitterJeu = new BoutonQuitter(Color.RED, this.ecran);
    }

    /**
     * Construction du composants
     */
    public void buildComposant() {
        this.setLayout(new GridLayout(1, 2));
        lancerJeu.build();
        quitterJeu.build();

        this.add(lancerJeu);
        this.add(quitterJeu);
    }

    


    

}
