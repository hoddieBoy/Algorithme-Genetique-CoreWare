package vue.composants.plateau;

import javax.swing.*;

import javax.swing.border.Border;

import java.awt.*;


import static vue.Constante.*;

/**
 * <b>Classe représentant la vue sur une case mémoire du CoreWar</b>
 * 
 * <p>
 *  La vue d'une case memoire par défaut est de couleur noire. Quand une
 *  écriture est faite sur cette derniere, une croix apparait. Cependant
 *  quand elle est lu, elle est colorié. En fonction du joueur qui a la main sur
 *  la partie, la croix ou le remplissage prend une couleur rouge ou bleu
 * </p>
 * 
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr>22013393@etu.unicaen.fr</a>
 * @version 1.0
 */
public class CaseMemoire extends JPanel {

    private final Color [] color = { Color.BLUE, Color.RED};

    /**
     * L'etat actuelle de la case memoire
     */
    private int etat;
    
    /**
     * Le joueur qui a actuel la main sur la memoire
     */
    private int tour;

    /**
     * Construit une case memoire
     * 
     * @param etat l'état du jeu 
     * @param tour le tour en cours
     */
    public CaseMemoire(int etat, int tour) {
        super();
        this.etat = etat;
        this.tour = tour;
        setSize(TAILLE_CASE, TAILLE_CASE);
        setBackground(Color.DARK_GRAY);
        Border lineBorder = BorderFactory.createLineBorder(Color.WHITE);
        Border g = BorderFactory.createRaisedSoftBevelBorder();
        this.setBorder(BorderFactory.createCompoundBorder(lineBorder, g));

    }
    public CaseMemoire() {
        this(-1, 0);
    }

    /**
     * Modifie l'état du jeu
     * @param etat l'état du jeu
     */
    public void setEtat(int etat) {
        this.etat = etat;
    }

    /**
     * Dessine le graphics initial 
     * @param g le graphique
     */
    private void paintInitial(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
        
    }

    /**
     * Dessine la case écrit
     * @param g le graphique
     * @param color la couleur de la case écrit
     */
    private void paintCaseEcrit(Graphics g, Color color) {
        paintInitial(g);
        g.setColor(color);
        g.drawLine(0, 0, this.getWidth(), this.getHeight());
        g.drawLine(0, this.getHeight(), this.getWidth(), 0);
    }

    /**
     * Dessine la case lue 
     * @param g le graphique
     * @param color la couleur de la case lue
     */
    private void paintCaseLu(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect(1, 1, this.getWidth() - 1, this.getHeight() - 1);
    }

    /**
     * Modifie le nombre de tour
     * @param tour  le nombre de tour
     */
    public void setTour(int tour) {
        this.tour = tour;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch (etat) {
            case -1:
                paintInitial(g);
                break;
            case 0:
                paintCaseEcrit(g, color[tour]);
                break;

            case 1:
                paintCaseLu(g, color[tour]);
                break;
        }
    }
}
