package vue.composants.plateau;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import lombok.Getter;
import vue.ElementVue;

import static vue.Constante.*;

import java.awt.*;

/**
 * Classe représante une vue sur la {@link modele.memoire.Memoire}
 * 
 * <p>
 *  La memoire est representé graphiqument par une grille 2D qui
 *  sera rempli au fur et à mesure de l'excecution
 * <p>
 * 
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 * @version 1.0
 */

@Getter
public class PlateauJeu extends JPanel implements ElementVue{

    /** 
     * Tableau de case memoire
    */
    private CaseMemoire[] casesMemoires;

    /**
     * Construit le plateau de jeu(la grille de memoire)
    */
    public PlateauJeu() {

        this.casesMemoires = new CaseMemoire[NB_CASES];
    }

    /**
     * Initialise la case mémoire
     */
    private void initialiserCasesMemoires() {
        for (int i = 0; i < NB_CASES; i++) {
            this.casesMemoires[i] = new CaseMemoire();
            this.add(casesMemoires[i]);
        }
    }

    @Override
    public void buildComposant() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(HAUTEUR_PLATEAU, LARGEUR_PLATEAU));
        this.setBackground(Color.GRAY);
        this.setLayout(new GridLayout(NB_LIGNES, NB_COLONNES));
        this.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        initialiserCasesMemoires();
    }



    /**
     * Modifie la case mémoire
     * @param index l'indice de la case
     * @param etat l'état du jeu
     * @param tour le nombre de tour
     */
    public void modifierCasesMemoire(int index, int etat, int tour) {
        casesMemoires[index].setEtat(etat);
        casesMemoires[index].setTour(tour);
        casesMemoires[index].updateUI();
    }

    @Override
    public void initialiserEvenements() {
        // TODO Auto-generated method stub
        
    }

}
