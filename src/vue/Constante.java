package vue;

import static application.Constante.TAILLE_MEMOIRE;

/**
 * Classe finale representant une constante
 */
public final class Constante {

    
    /**Le nombre de ligne du plateau */
    public static final int NB_LIGNES = 16;
    /**Le  nombre de colonne du plateau*/
    public static final int NB_COLONNES = TAILLE_MEMOIRE / NB_LIGNES;
    /** Le nombre de cases du plateau*/
    public static final int NB_CASES = NB_LIGNES * NB_COLONNES;

    /**La taille preferencielle d'une case*/
    public static final int TAILLE_CASE = 50;

    /**La largeur preferencielle du plateau*/
    public static final int LARGEUR_PLATEAU = TAILLE_CASE * NB_COLONNES;
    
    /**La hauteur preferencille du plateau*/
    public static final int HAUTEUR_PLATEAU = TAILLE_CASE * NB_LIGNES;

    /** Largeur d'un bouton */
    public static final int LARGEUR_BOUTON = 160;

    /** Hauteur d'un bouton */
    public static final int HAUTEUR_BOUTON = 100;

    private Constante() {
    }


}
