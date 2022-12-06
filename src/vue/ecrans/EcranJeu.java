package vue.ecrans;

import java.awt.*;

import lombok.Getter;
import vue.CoreWar;
import vue.composants.ZonesInformations;
import vue.composants.boutons.ZoneBoutons;
import vue.composants.plateau.PlateauJeu;

/**
 * Classe représentant l'éclan du jeu
 */
public class EcranJeu extends AbstractEcran {
    /* Les Attributs de la classe */

    @Getter
    private PlateauJeu plateau; // Le plateau du jeu
    private ZoneBoutons zoneBoutons; // La zone des boutons 
    @Getter
    private ZonesInformations zonesInformation; // Les zones d'information

    /**
     * Constructeur de la classe
     * @param frame fenêtre de niveau supérieur avec une bordure et une barre de titre
     */
    public EcranJeu(CoreWar frame) {
        super(frame);
        this.plateau = new PlateauJeu();
        this.zoneBoutons = new ZoneBoutons(frame);
        this.zonesInformation = new ZonesInformations();

    }

    @Override
    public void buildComposant() {
        super.buildComposant();
        zoneBoutons.build();
        zonesInformation.build();
        plateau.build();
        this.add(zonesInformation, BorderLayout.NORTH);
        this.add(zoneBoutons, BorderLayout.WEST);
        this.add(plateau, BorderLayout.CENTER);
    }

}
