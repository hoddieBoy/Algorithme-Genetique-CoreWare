package controleur;

import java.util.Random;

import application.Constante;
import lombok.Getter;
import lombok.Setter;
import modele.combattant.Warrior;
import modele.memoire.Interpreteur;
import modele.memoire.composants.Addresse;

/** 
 * Classe représentant le controleur du CoreWar
 */
@Getter
@Setter
public class Controleur {

    /* Attributs de la classe */

    /** L'interpreteur associé à la memoire */
    protected Interpreteur interpreteur;

    /** Le premier warrior */
    protected Warrior premierCombatant;

    /** Le deuxieme combatant */
    protected Warrior deuxiemeCombatant;

    protected int score1 = 0;
    protected int score2 = 0;

    protected int tour = 0;

    private int partie = 0;

    /** Constructeur de la clasee
     * @param interpreteur l'interpreteur associé à la mémoire
     * @param premierCombatant le premier combatant ou warrior
     * @param deuxiemeCombatant le deuxieme combatant ou warrior
    */

    public Controleur(Interpreteur interpreteur, Warrior premierCombatant, Warrior deuxiemeCombatant) {
        this.interpreteur = interpreteur;
        this.premierCombatant = premierCombatant;
        this.deuxiemeCombatant = deuxiemeCombatant;
    }

    /** 
     * Chargement du warrior
     */
    public void chargementWarriors() {
        Random r = new Random();
        int debutChargement1 = r.nextInt(Constante.TAILLE_MEMOIRE);
        int debutChargement2 = r.nextInt(Constante.TAILLE_MEMOIRE);
        while (Math.abs(debutChargement1 - debutChargement2) > (Constante.TAILLE_MEMOIRE) / 2) {
            debutChargement2 = r.nextInt(Constante.TAILLE_MEMOIRE);
        }
        premierCombatant.chargerWarrior(interpreteur.getMemoire(), debutChargement1);
        tour = 1;
        deuxiemeCombatant.chargerWarrior(interpreteur.getMemoire(), debutChargement2);
        tour = 0;

        partie = 0;


    }

    /**
     * Reinitialise toute les variables
     */
    public void reinitialise() {
        this.score1 = 0;
        this.score2 = 0;
        this.interpreteur.getMemoire().initMemoire();
        
        this.partie = 0;
        this.tour = 0;

        this.premierCombatant.getProcessus().clear();
        this.deuxiemeCombatant.getProcessus().clear();

    }

    /** 
     * Execution du jeu
    */
    public void excecute() {

        Addresse processusCourant;

            if (tour == 0) {
                System.out.println(tour);
                System.out.println(premierCombatant.getProcessus());
                processusCourant = premierCombatant.getProcessus().pop();
                score2 += processusCourant.equals(new Addresse()) ? 1 : 0;
                this.interpreteur.addProcessus(processusCourant);
                this.interpreteur.interpreter();
                premierCombatant.getProcessus().addAll(interpreteur.getFileAttentesProcessus().removeAll());
                System.out.println(premierCombatant.getProcessus());
            }

            else {
                System.out.println(tour);

                System.out.println(deuxiemeCombatant.getProcessus());

                processusCourant = deuxiemeCombatant.getProcessus().pop();
                score1 += processusCourant.equals(new Addresse()) ? 1 : 0;

                this.interpreteur.addProcessus(processusCourant);
                this.interpreteur.interpreter();
                deuxiemeCombatant.getProcessus().addAll(interpreteur.getFileAttentesProcessus().removeAll());
                System.out.println(deuxiemeCombatant.getProcessus());

            }
            tour = (tour + 1) % 2;
        

        partie += 1;

    }
    
    public boolean isOver() {
        return premierCombatant.isOver() || deuxiemeCombatant.isOver();
    }

}
