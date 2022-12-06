package modele.combattant;

import java.util.LinkedList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import modele.memoire.Memoire;
import modele.memoire.composants.Addresse;
import modele.memoire.composants.FileProcessus;

/**
 * Classe representante un warrior(combattant) du coreWar
 * 
 * <p>
 *  Un warrior est un programme écrit en redcode et qui peut être
 *  excecuté par une machine virtuel. Ainsi cet objet stocke:
 * <p>
 * <ul>
 *  <li>Le programme auquel il est rattaché</li>
 *  <li>La liste d'attentes de ces processus courant</li>
 * </ul>
 * 
 * @author OROU-GUIDOU Amirath Fara <a href="mailto:22012235@etu.unicaen.fr">22012235@etu.unicaen.fr</a>
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 * 
 * @version 1.0
 * 
 * @see controleur.Controleur#premierCombatant
 * @see controleur.Controleur#deuxiemeCombatant
 */
@Getter
@Setter
@EqualsAndHashCode
public class Warrior {

    /** 
     * Liste d'operation du warrior
     * 
     * --Getter--
     * Retourne le programme associé au warrior
     * @return un programme
     * 
     * --Setter--
     * Modifie le programme associé au warrior
     * @param programme le nouveau programme
    */
    private Programme programme;

    /** 
     * Liste des processus du warrior
     * 
     * --Getter--
     * Retourne la liste de processus du warrior
     * @return la liste de processus du warrior
     * 
     * --Setter--
     * Modifie la liste de processus du warrior
     * @param processus  la nouvelle liste de processus
    */
    private FileProcessus processus;


    /**
     * Construit une nouvelle instance d'un warrior
     * 
     * @param programme le programme associé au warrior
     */
    public Warrior(Programme programme) {
        this.programme = programme;
        this.processus = new FileProcessus();
    }

    /**
     * Charge le warrio dans une memoire virtuel
     * @param memory la memoire dans laquelle s'effectue le chargement
     * @param addresse l'adresse de debut de chargement;
     */
    public void chargerWarrior(Memoire memory, int addresse) {
        
        memory.ecriture(programme.getListeInstructions(), addresse);
        processus.add(new Addresse(addresse));
    }


    /**
     * Retourne le nombre de processus que possède un warrior
     * @return un entier
     */
    public int nombreProcessus() {
        return processus.size();
    }

    /**
     * Renvoie un boolean indiquant si le warrior est en vie
     * 
     * <p>
     *  Un warriror est en vie si la liste de ses processus possède au moins un element
     * </p>
     * @return un boolean
     */
    public boolean isOver() {
        return processus.isEmpty();
    }

    @Override
    public String toString() {
        return String.format("Warrior(taille du programme = %d, nombre de processus = %d)",
                                        programme.taille(), processus.size());
    }
}
