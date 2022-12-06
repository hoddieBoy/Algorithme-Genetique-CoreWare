package vue.composants.boutons;


import javax.swing.JPanel;
import java.awt.*;
import vue.CoreWar;

public class ZoneBoutons extends AbstractZoneBouton {

    private BoutonJouer boutonJouer;
    private BoutonPause boutonPause;
    private BoutonQuitter boutonQuitter;
    private BoutonChargement boutonChargement;
    private BoutonReinitialiser boutonReinitialiser;

    public ZoneBoutons(CoreWar fenetre) {
        super(fenetre);
        this.boutonJouer = new BoutonJouer(Color.GREEN, fenetre);
        this.boutonPause = new BoutonPause(Color.MAGENTA, fenetre);
        this.boutonQuitter = new BoutonQuitter(Color.RED, fenetre);
        this.boutonChargement = new BoutonChargement(Color.YELLOW, fenetre.getControleur());
        this.boutonReinitialiser = new BoutonReinitialiser(new Color(84,123,52), fenetre.getControleur()); //
    }
    @Override
    public void buildComposant() {
        setLayout(new GridLayout(5, 1));
        boutonQuitter.build();
        boutonJouer.build();
        boutonPause.build();
        boutonChargement.build();
        boutonReinitialiser.build();
        add(boutonJouer);
        add(boutonPause);
        add(boutonChargement);
        add(boutonReinitialiser);
        add(boutonQuitter);
    }

}
