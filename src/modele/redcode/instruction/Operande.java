package modele.redcode.instruction;

import static application.Constante.*;

import lombok.Getter;
import lombok.Setter;
import modele.redcode.enumeration.Mode;

/** 
 * <b>Classe representante une operande d'une instruction de redcode</b>
 * 
 * <p>
 *  Une operande est un composant d'une instruction de redcode.
 *  Elle est déccoupé en 2 partie distincte
 * </p>
 * 
 * <ul>
 *  <li>Un mode d'adressage</li>
 *  <li>une valeur </li>
 * </ul>
 * 
 * <p>
 *  Le format des operandes est <strong> "Mode  __ valeur "</strong>
 * </p>
 * 
 * @author OROU-GUIDOU Amirath Fara <a href="mailto:22012235@etu.unicaen.fr">22012235@etu.unicaen.fr</a>
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 * 
 * @version 1.0
 * 
 */
@Getter
@Setter
public class Operande {
    
    //****************************************************************
    // ATTRIBUTS DE LA CLASSE
    //****************************************************************

    /**
     * Le mode d'addressage de l'operande
     * 
     * --Getter--
     * Retourne le mode d'addressage de l'operande
     * @return un mode d'addressage
     * 
     * --Setter--
     * Modifie le mode d'addressage de l'operande
     * @param mode le nouveau mode d'adressage
     */
    private Mode mode;

    /**
     * La valeur de l'operande
     * 
     * --Getter--
     * Retourne la valeur de l'operande
     * @return la valeur de l'operande
     * 
     * --Setter--
     * Modifie la valeur de l'operande
     * @param valeur
     */
    private int valeur;


    //****************************************************************
    // CONSTRUCTEUR DE LA CLASSE
    //****************************************************************

    /**
     * Construit une nouvelle instance d'une operande
     * 
     * @param mode le mode d'adressage de l'operande
     * @param valeur la valeur de l'operande
     */

    public Operande(Mode mode, int valeur) {

        this.mode = mode;
        this.valeur = valeur;
    }
    
    /**
     * Construit une nouvelle instance d'une operande à partir d'une chaine caractere
     * 
     * <p>
     *  Utilise une chaine de caractere possedant le format <strong>" Mode __ valeur "</strong>
     * pour la spliter en 2 partir et construire l'operande
     * <p>
     * @param operande
     */
    public Operande(String operande) {
        String separator = "\\s+";
        String[] tab = operande.split(separator);
        this.mode = Mode.fromString(tab[0]);
        this.valeur = Integer.parseInt(tab[1]);
    }

    /**
     * 
     * Construit une nouvelle instance d'une operande
     * 
     * @param mode  un string representant le mode d'addressage de l'operande
     * @param valeur le valeur de l'operande
     * 
     */
    public Operande(String mode, int valeur) {

        this(mode+" "+ valeur);
    }

    /**
     * Creer une copie d'une operande
     * 
     * @param operande l'operande à copier
     */
    public Operande(Operande operande) {

        this(operande.getMode(), operande.getValeur());
    }

    //****************************************************************
    // METHODES DE LA CLASSE
    //****************************************************************

    @Override
    public String toString() {
        return String.format("%s %d", mode, valeur);
    }

}
