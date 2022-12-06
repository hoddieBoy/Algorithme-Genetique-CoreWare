package modele.redcode.enumeration;


/**
 * <b>Classe representant une Opcode d'une instruction en redCode</b>
 *  
 * <p>
 *  Une classe énumérative contenant l'ensemble des valeurs
 *  que peuvent prendre une Opcode d'une instruction en redCode
 * </p>
 * 
 * <p>
 *  La version actuelle de l'application possède 12 opcodes distincts
 * </p>
 * 
 * @author OROU-GUIDOU Amirath Fara <a href="mailto:22012235@etu.unicaen.fr">22012235@etu.unicaen.fr</a>
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 * 
 * @version 1.0
 * 
 * @see modele.redcode.instruction.Instruction
 * @see modele.memoire.Interpreteur
 * @see modele.memoire.composants.Cellule
 */

public enum Opcode{

    //****************************************************************
    // CONSTANTES ENUMERATIVE
    //****************************************************************

    /**
     * Opcode d'une bombe 
    */
    DAT("DAT"),

    /**
     * Opcode d'une instruction effectuant un deplacement
     */
    MOV("MOV"),

    /**
     * Opcode d'une instruction effectuant une addition
     */
    ADD("ADD"),

    /**
     * Opcode d'une instruction effectuant une soustraction
     */
    SUB("SUB"),

    /**
     * Opcode d'une instruction effectuant un saut sans conditions
     */
    JMP("JMP"),

    /**
     * Opcode d'une instruction effectuant un saut si l'operande B a une valeur nulle
     */
    JMZ("JMZ"),

    /**
     * Opcode d'une instruction effectuant un saut si l'operande B a une valeur non nulle
     */
    JMN("JMN"),

    /**
     * Opcode d'une instruction effectuant un saut si les 2 operandes sont egales
     */
    CMP("CMP"),

    /**
     * Opcode d'une instruction effectuant un saut si l'operande A est plus petit que l'operande B
     */
    SLT("SLT"),

    /**
     * Opcode d'une instruction effectuant un saut si aprsè decrementation l'operande B est nulle
     */
    DJZ("DJZ"),
    
    /**
     * Opcode d'une instruction effectuant un saut si aprsè decrementation l'operande B est nulle
     */
    DJN("DJN"),

    /**
     * Opcode d'une instruction rajoutant un processus à la file d'attentes
     */
    SPL("SPL");


    //****************************************************************
    // ATTRIBUTS
    //****************************************************************

    /**
     * Une abreviation de l'opcode
     */
    private String abreviation;

    //****************************************************************
    // CONSTRUCTEUR
    //****************************************************************

    /**
     * Constructeur privé des enumerations
     * @param abreviation
     */
    Opcode(String abreviation) {
        //Le constructeur d'une classe enumerative est implicitement privé
        this.abreviation = abreviation;

    }


    //****************************************************************
    // METHODES
    //****************************************************************

    /**
     * Retourne l'opcode associé à une abreviation
     * 
     * @param abreviation l'abreviation dont on recherche l'opcode
     * @return opcode
     * @see modele.redcode.instruction.Instruction
     */
    public static Opcode fromString(String abreviation) {

        for (Opcode i : Opcode.values()) {

            if (i.abreviation.equals(abreviation)) {

                return i;

            }

        }

        return null;

    }
    
    @Override
    public String toString(){
        return abreviation;
    }


}