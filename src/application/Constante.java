package application;

/**
 * Classe contenant toute les constantes de l'application
 * 
 * @version 1.0
 */

public final class Constante {

    public static final int TAILLE_MEMOIRE = 800;
    public static final int LONGUEUR = TAILLE_MEMOIRE / 10;
    public static final int LARGEUR = 10;

    private Constante() {

    }

    /**
     * Calcule le modulo d'une valeur
     * 
     * @param valeur
     * 
     * @return une valeur
     */
    public static int modulo(int valeur) {
        return Math.floorMod(valeur, TAILLE_MEMOIRE);
    }
}