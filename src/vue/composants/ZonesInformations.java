package vue.composants;

import javax.swing.*;
import java.awt.*;

/**
 * Classe représentant la zone d'information des joueurs
 */
public class ZonesInformations extends JPanel {
    /* Attributs de la classe */
    private JLabel informationJoueur1; /** Information du premier joueur */
    private JLabel informationJoueur2; /** Information du deuxieme joueur*/
    private int scoreJoueur1; /** Score du premier joueur */
    private int scoreJoueur2; /** Score du deuxieme joueur */

    /**
     * Constructeur de la classe 
     */
    public ZonesInformations() {
        this.informationJoueur1 = new JLabel("Score Joueur 1 : 0");
        this.informationJoueur2 = new JLabel("Score Joueur 2 : 0");
        this.scoreJoueur1 = 0;
        this.scoreJoueur2 = 0;
    }

    /**
     * Construction de la zone d'information
     */
    public void build() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        this.add(informationJoueur1);
        this.add(informationJoueur2);
    }

    /**
     * Modifie le score des joueurs
     * @param joueur le joueur
     * @param score le score du joueur
     */
    public void setScoreJoueur(int joueur, int score) {
        if (joueur == 1) {
            this.scoreJoueur1 = score;
        }
        else if (joueur == 2) {
            this.scoreJoueur2 = score;
        }

        repaint();
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        this.informationJoueur1.setText("Score Joueur 1 : " + this.scoreJoueur1);
        this.informationJoueur2.setText("Score Joueur 2 : " + this.scoreJoueur2);
        
    }
    
}
