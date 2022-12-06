package genetique;

import java.util.Comparator;

import modele.combattant.Programme;
import modele.redcode.enumeration.Opcode;
import modele.redcode.instruction.Instruction;

/**
 * Classe représentant le comparateur du programme
 */
public class ComparateurProgramme implements Comparator<Programme> {

    @Override
    public int compare(Programme p0, Programme p1) {

        
        int diffRang = compareRang(p0, p1);
        if (diffRang == 0) {
            int diffEfficacite = compareEfficacite(p0, p1);

            if (diffEfficacite == 0) {

                return compareTaille(p0, p1);
            }

            return diffEfficacite;
        }
        return diffRang;
    }
    

    /**
     * Compare le rang de  deux programmes
     * @param p1 le premier programme
     * @param p2 le deuxieme programme
     */

    public int compareRang(Programme p1, Programme p2) {
        Evaluation evaluateur = new Evaluation();
        Integer rangP1 = evaluateur.rangProgramme(p1);
        Integer rangP2 = evaluateur.rangProgramme(p2);

        return rangP1.compareTo(rangP2);

    }

    /**
     * Compare la taille de deux programme
     * @param p1 le premier programme
     * @param p2 le deuxieme programme
     */
    public int compareTaille(Programme p1, Programme p2) {
        Integer tailleP1 = p1.taille();
        Integer tailleP2 = p2.taille();

        return tailleP1.compareTo(tailleP2);
    }

    /** 
     * Compare l'éfficacité de deux programme
     * @param p1 le premier programme
     * @param p2 le deuxieme programme
     */ 
    public int compareEfficacite(Programme p1, Programme p2) {
        
        Integer nbInstructionDATP1 = 0;
        Integer nbInstructionDATP2 = 0;

        for (Instruction instruction : p1.getListeInstructions()) {

            nbInstructionDATP1 += instruction.getOpcode() == Opcode.DAT ? 1 : 0;
        }

        for (Instruction instruction : p2.getListeInstructions()) {

            nbInstructionDATP2 += instruction.getOpcode() == Opcode.DAT ? 1 : 0;
        }

        return nbInstructionDATP1.compareTo(nbInstructionDATP2);
    }

}
