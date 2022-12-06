package genetique;

import modele.combattant.Programme;
import modele.memoire.Interpreteur;
import modele.memoire.Memoire;

import static application.Constante.TAILLE_MEMOIRE;
import static  genetique.Constante.RANG_MAX;

import java.util.Random;

/**
 * Classe representante un evaluateur
 * 
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 * @version 1.0
 */
public class Evaluation {

    private Memoire memoire = new Memoire();
    private Random rand = new Random();
    private Interpreteur interpreteur = new Interpreteur(memoire);

    /**
     * Détermine le rang d'un programme
     * @param programme le programme
     */
    public int rangProgramme(Programme programme) {
        int rang = 0;
        int i = rand.nextInt(TAILLE_MEMOIRE);
        Programme p = new Programme(programme);
        memoire.initMemoire();
        interpreteur.viderFileAttentesProcessus();
        memoire.ecriture(p.getListeInstructions(), i);
        interpreteur.addProcessus(i);
        while (rang < RANG_MAX
                    && !interpreteur.getFileAttentesProcessus().isEmpty()) {
            interpreteur.interpreter();
            rang++;
        }

        return rang;
    }

}
