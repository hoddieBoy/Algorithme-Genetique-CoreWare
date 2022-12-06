package modele.redcode.instruction;

import modele.redcode.enumeration.Opcode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <b> Classe representante une instruction du langage de programmation redcode </b>
 * 
 * <p>
 *  Une classe permettant de modeliser une instruction en redcode.
 *  Une instruction en redCode est decompose en 3 partie
 * </p>
 * <ul>
 *  <li>Une opcode</li>
 *  <li>Une premiere operande nommé couramment operandeA</li>
 *  <li>Une deuxieme operande nommé couramment operandeB</li>
 * </ul>
 * <p>
 *  Cette version de l'application accepte uniquement les instructions possedant le format:
 *  <strong> " Opcode  __ OperandeA  __ OperandeB " </strong>
 * </p>
 * 
 * @author OROU-GUIDOU Amirath Fara <a href="mailto:22012235@etu.unicaen.fr">22012235@etu.unicaen.fr</a>
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 *  
 * @version 1.0
 */
@Getter
@Setter
@EqualsAndHashCode(of = {"opcode", "operandeA", "operandeB"})
public class Instruction {

    //****************************************************************
    // ATTRIBUTS DE LA CLASSE
    //****************************************************************

    /**
     * L'opcode de l'instruction
     * 
     * --Getter--
     * Retourne l'opcode de l'instruction
     * @return opcode
     * 
     * --Setter--
     * Modifie l'opcode de l'instruction
     * @param opcode
     */
    private Opcode opcode;

    /**
     * La premiere operande
     * 
     * --Getter--
     * Retourne la premiere operande de l'instruction
     * @return operande
     * 
     * --Setter--
     * Modifie la premiere operande de l'instruction
     * @param operandeA
     */
    private Operande operandeA;

    /**
     * La deuxieme operande
     * 
     * --Getter--
     * Retourne la deuxieme operande de l'instruction
     * @return operande
     * 
     * --Setter--
     * Modifie la deuxieme operande de l'instruction
     * @param operandeB
     */
    private Operande operandeB;


    //****************************************************************
    // CONSTRUCTEUR DE LA CLASSE
    //****************************************************************


    /**
     * Construit une nouvelle instance d'une instruction
     * 
     * @param opcode l'opcode de l'instruction
     * @param operandeA La premiere operande de l'instruction
     * @param operandeB La deuxieme operande de l'instruction
     */
    public Instruction(Opcode opcode, Operande operandeA, Operande operandeB) {

        this.opcode = opcode;
        this.operandeA = operandeA;
        this.operandeB = operandeB;
    }

    /**
     * Construit une nouvelle instance d'une instruction a partir d'une chaine de
     * caracteres
     * 
     * @param ligne La chaine de caracteres contenant une operation
     */
    public Instruction(String ligne) {

        String separteur = "\\s+";
        String[] mot = ligne.split(separteur);

        this.opcode = Opcode.fromString(mot[0]);
        this.operandeA = new Operande(mot[1],
                            Integer.valueOf(mot[2]));
        this.operandeB = new Operande(mot[3], 
                            Integer.valueOf(mot[4]));

    }

    /**
     * Construit une nouvelle instance d'une instruction possedant une seule operande
     * 
     * @param opcode L'instruction de l'operation La chaine
     * @param operandeA la premiere operande
     */
    public Instruction(Opcode opcode, Operande operandeA) {

        this(opcode, operandeA, new Operande("$ 0"));
    }

    /**
     * Construit une copie d'une operation
     * 
     * @param instruction l'instruction à copier
     */
    public Instruction(Instruction instruction) {

        this.opcode = instruction.getOpcode();
        this.operandeA = new Operande(instruction.getOperandeA());
        this.operandeB = new Operande(instruction.getOperandeB());
    }


    //****************************************************************
    // METHODES DE LA CLASSE
    //****************************************************************


    @Override
    public String toString() {
        return opcode + " " + operandeA + " " + operandeB;
    }

}
