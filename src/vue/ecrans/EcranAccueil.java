package vue.ecrans;

import java.awt.*;
import javax.swing.*;

import vue.CoreWar;
import vue.composants.boutons.ZoneBoutonsAccueil;

/**
 * Classe représentant l'écran d'accueil du jeu (CoreWar)
 */
public class EcranAccueil extends AbstractEcran {

    /* Les Attributs de la classe */
    private Image imgFond; // Image du fond de l'écran d'accueil du jeu (CoreWar)
    private ZoneBoutonsAccueil zoneBoutons; // Zones des boutons d'accueil

    /**
     * Constructeur de la classe
     * @param frame fenêtre d'accueil de niveau supérieur avec une bordure et une barre de titre
     * @param nomFondEcran nom du fond de l'écran d'accueil
     */
    public EcranAccueil(CoreWar frame, String nomFondEcran) {
        super(frame);
        this.imgFond = new ImageIcon(nomFondEcran).getImage();
        this.zoneBoutons = new ZoneBoutonsAccueil(this.ecran);

    }

    @Override
    public void buildComposant() {
        super.buildComposant();
        zoneBoutons.build();
        this.add(zoneBoutons, BorderLayout.SOUTH);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.imgFond, 0, 0, getWidth(), getHeight(), this);

    }

    

}
