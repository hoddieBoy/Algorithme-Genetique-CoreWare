package modele.memoire.composants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import modele.redcode.instruction.Instruction;

/**
 * <b>Classe representante une cellule memoire</b>
 * 
 * <p>
 *  Une cellule est identifié par 2 informations
 * </p>
 * 
 * <ul>
 *  <li>Son addresse</li>
 *  <li>L'instruction qu'elle conserve</li>
 * </ul>
 * 
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 *  
 * @version 1.0
 */

@EqualsAndHashCode
public class Cellule {

    /** 
     * L'instruction contenu dans la cellule
     * 
     * --Getter--
     * Retourne l'instruction contenu dans la cellule
     * @return une instruction
     * 
     * --Setter--
     * Modifie l'instruction contenu dans la cellule
     * @param instruction la nouvelle instruction
     */
    @Getter
    @Setter
    private Instruction instruction;

    /**
     *  L'addresse memoire de la cellule 
     * 
     * --Getter--
     * Retourne l'addresse de la cellule
     * @return l'addresse de la cellule
    */
    @Getter
    private Addresse addresse;

    /**
     * Construit une nouvelle instance d'une cellule memoire
     * 
     * @param instruction l'instruction contenu dans la cellule
     * @param addresse l'addresse memoire de la cellule
     */
    public Cellule(Instruction instruction, Addresse addresse) {
        this.instruction = instruction;
        this.addresse = addresse;
    }

    /**
     * Construit une nouvelle instance d'une cellule memoire par defaut
     * 
     * @param addresse l'addresse memoire de la cellule
     */
    public Cellule(Addresse addresse) {
        this(new Instruction("DAT $ 0 $ 0"), addresse);
    }

    /**
     * Construit une nouvelle instance d'une cellule memoire par defaut
     * 
     * @param addresse l'addresse memoire de la cellule
     */
    public Cellule(int addresse) {
        this(new Addresse(addresse));
    }

    /**
     * Construit une nouvelle instance d'une cellule memoire
     * 
     * @param instruction l'instruction contenu dans la cellule
     * @param addresse l'addresse memoire de la cellule
     */
    public Cellule(Instruction instruction, int addresse) {
        this.instruction = instruction;
        this.addresse = new Addresse(addresse);
    }

    @Override
    public String toString() {
        return String.format("%s : [ %s ] ", Integer.toHexString(addresse.getNumero()) ,instruction);
    }
}
