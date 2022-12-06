package modele.redcode.enumeration;

/**
 * <b>Classe representant un mode d'adressage d'une operande en redcode</b>
 * 
 * <p>
 *  Une classe enumerative representant l'ensemble des modes
 *  d'adressage que possède une operande en redCode
 * </p>
 * 
 * <p>
 *  La version actuelle de l'application permet de gérer 4 modes d'adressage
 * </p>
 * 
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 * 
 * @version 1.0
 * 
 * @see modele.redcode.instruction.Operande
 * @see modele.redcode.instruction.Operande#mode
 * @see modele.memoire.Interpreteur#interpreter()
 */
public enum Mode {

    //****************************************************************
    // CONSTANTES ENUMERATIVE
    //****************************************************************

    /**
     * Mode d'adressage immediat
    */
    IMMEDIAT("#"),
    /**
     * Mode d'adressage indirect sur l'operande B
    */
    B_INDIRECT("@"),
    /**
     * Mode d'adressage indirect sur l'operande A
    */
    A_INDIRECT("*"),
    /**
     * Mode d'adressage direct
    */
    DIRECT("$");

    //****************************************************************
    // ATTRIBUTS
    //****************************************************************

    /**
     * Une abreviation du mode d'adressage
     */
    private String abreviation;

    //****************************************************************
    // CONSTRUCTEURS
    //****************************************************************

    /**
     * Constructeur privé des enumerations
     * @param abreviation
     */
    Mode(String abreviation) {
        //Le constructeur d'une classe enumerative est implicitement privé
        this.abreviation = abreviation;

    }

    //****************************************************************
    // METHODES
    //****************************************************************

    /**
     * Retourne le mode d'adressage associé à une abreviation
     * 
     * @param abreviation l'abreviation dont on recherche l'opcode
     * @return Mode
     * @see modele.redcode.instruction.Operande#Operande(String operande)
     */
    public static Mode fromString(String abreviation) {
        for (Mode m : Mode.values()){
            if (m.abreviation.equals(abreviation)){
                return m;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return abreviation;
    }
}
