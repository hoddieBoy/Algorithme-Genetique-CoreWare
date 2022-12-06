package genetique;

import java.util.Random;

import modele.combattant.Programme;
import modele.redcode.enumeration.Mode;
import modele.redcode.enumeration.Opcode;
import modele.redcode.instruction.Instruction;
import modele.redcode.instruction.Operande;

import static genetique.Constante.*;

/** 
 * Classe final  représentant la mutation de l'algorithme génétique
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 * @version 1.0
 */
public final class Mutation {

    private static Random random = new Random();

    private Mutation() {}

    /**
     * Mutation d'une opérande 
     * @param op une opérande
     * @return une nouvelle opérande
     */
    public static Operande mutationOperande(Operande op) {
        Mode[] modes = Mode.values();
        int taille = modes.length;
        int indice = random.nextInt(taille);
        int valeur = Math.abs(op.getValeur());
        valeur = -valeur + random.nextInt(2*(valeur)+1);
        return new Operande(modes[indice], valeur);
    }

    /**
     * Mutation d'une instruction 
     * @param instruction une instruction
     * @return une nouvelle instruction
     */
    public static Instruction mutationOperation(Instruction instruction) {
        Opcode[] opcodes = Opcode.values();
        int taille = opcodes.length;
        int indice = random.nextInt(taille);
        Opcode opcode;
        Operande operandeA;
        Operande operandeB;
        if (random.nextDouble() < COEFFICIENT_MUTATION_INSTRUCTION) {
            opcode = opcodes[indice];
        } else {
            opcode = instruction.getOpcode();
        }

        if (random.nextDouble() < COEFFICIENT_MUTATION_OPERANDE) {
            operandeA = mutationOperande(instruction.getOperandeA());
        } else {
            operandeA = new Operande(instruction.getOperandeA());
        }

        if (random.nextDouble() < COEFFICIENT_MUTATION_OPERANDE) {
            operandeB = mutationOperande(instruction.getOperandeB());
        } else {
            operandeB = new Operande(instruction.getOperandeB());
        }

        return new Instruction(opcode, operandeA, operandeB);

    }

    /** 
     * Mutation d'un programme
     * @param programme un programme
     * @return un nouveau programme
    */
    public static Programme mutationProgramme(Programme programme) {
        int indiceOperation = random.nextInt(programme.getListeInstructions().size());
        Programme nouveauProgramme = new Programme(programme);
        nouveauProgramme.setInstruction(indiceOperation,
                mutationOperation(nouveauProgramme.getOperation(indiceOperation)));

        return nouveauProgramme;

    }
}
