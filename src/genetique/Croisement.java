package genetique;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import modele.combattant.Programme;
import modele.redcode.enumeration.Opcode;
import modele.redcode.instruction.Instruction;
import modele.redcode.instruction.Operande;

/** 
 * Classe représentant un croisement
 * 
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 * @version 1.0
 */
public final class Croisement {

    private static Random rand = new Random();

    private Croisement() {

    }

    /**
     * Croise deux opérandes
     * @param op1 premiere opérande
     * @param op2 deuxieme opérande
     */

    public static List<Operande> croisementOperande(Operande op1, Operande op2) {
        List<Operande> result = new ArrayList<>();
        result.add(new Operande(op1.getMode(), op2.getValeur()));
        result.add(new Operande(op2.getMode(), op1.getValeur()));
        return result;
    }

    /**
     * Croise deux opérations 
     * @param operation1 premiere opération
     * @param operation2 deuxieme opération
     */

    public static List<Instruction> croisementOperation(Instruction operation1, Instruction operation2) {
        List<Instruction> result = new ArrayList<>();

        List<Operande> listeCroisementOperandeA = croisementOperande(operation1.getOperandeA(),
                                                                        operation2.getOperandeA());
        List<Operande> listeCroisementOperandeB = croisementOperande(operation1.getOperandeB(),
                                                                        operation2.getOperandeB());
        List<Opcode> listInstructions = new ArrayList<>();
        listInstructions.add(operation1.getOpcode());
        listInstructions.add(operation2.getOpcode());
        Set<Instruction> instructions = new HashSet<>();
        for (Opcode instruction : listInstructions) {
            for (Operande opA : listeCroisementOperandeA) {
                for (Operande opB : listeCroisementOperandeB) {
                    instructions.add(new Instruction(instruction, opA, opB));
                }
            }

        }
        result.addAll(instructions);
        return result;
    }

    /**
     * Croise les listes de programme
     * @param programme1 premier programme
     * @param programme2 deuxieme programme
     */

    public static List<Programme> croisementProgrammes(Programme programme1, Programme programme2) {
        List<Programme> programmes = new ArrayList<>();
        int indiceInstruction1 = rand.nextInt(programme1.getListeInstructions().size());
        int indiceInstruction2 = rand.nextInt(programme2.getListeInstructions().size());
        List<Instruction> operations = croisementOperation(programme1.getOperation(indiceInstruction1),
                programme2.getOperation(indiceInstruction2));
        Set<Programme> programmeSet = new HashSet<>();
        for (Instruction op : operations) {
            Programme nouveauProgramme1 = new Programme(programme1);
            Programme nouveauProgramme2 = new Programme(programme2);

            nouveauProgramme1.setInstruction(indiceInstruction1, op);
            nouveauProgramme2.setInstruction(indiceInstruction2, op);

            programmeSet.add(nouveauProgramme1);
            programmeSet.add(nouveauProgramme2);

        }
        programmeSet.add(programme2);
        programmeSet.add(programme1);
        programmes.addAll(programmeSet);
        return programmes;

    }
    
    /**
     * Croise deux programmes
     * @param programme1 premier programme
     * @param programme2 deuxieme programme
     */
    public static List<Programme> croisementProgramme(Programme programme1, Programme programme2) {
        List<Programme> programmes = new ArrayList<>();
        int indiceInstruction1 = rand.nextInt(programme1.taille());
        int indiceInstruction2 = rand.nextInt(programme2.taille());
        List<Instruction> operations = croisementOperation(programme1.getOperation(indiceInstruction1),
                programme2.getOperation(indiceInstruction2));
        int choix = rand.nextInt(operations.size());
        Programme programme;
            programme = new Programme(programme1);
            programme.setInstruction(indiceInstruction1, operations.get(choix));

            programmes.add(programme);
            programme = new Programme(programme2);
            choix = rand.nextInt(operations.size());

            programme.setInstruction(indiceInstruction2, operations.get(choix));
                        programmes.add(programme);

        return programmes;
    }
}
