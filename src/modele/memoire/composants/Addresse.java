package modele.memoire.composants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import application.Constante;

/**
 * <b>Classe representante une adresse d'une cellule memoire</b>
 * 
 * <p>
 *   Une adresse est un entier dont le numero est inferieur à {@link application.Constante#TAILLE_MEMOIRE}.
 *  Cet objet est muni d'une addition, d'une soustraction qui permet d'obtenir d'audre addresse memoire
 * </p>
 * 
 * @author OROU-GUIDOU Amirath Fara <a href="mailto:22012235@etu.unicaen.fr">22012235@etu.unicaen.fr</a>
 * 
 * @version 1.0
 */

@Getter
@Setter
@EqualsAndHashCode
public class Addresse {

    /** 
     * Le numero de l'addresse
     * 
     * --Getter--
     * Retourne le numero de l'addresse
     * @return un entier
     * 
     * --Setter--
     * Modifie le numero de l'adresse
     * @param numero le nouveau numero de l'adresse
     */
    private int numero;

    /**
     * Construit une nouvelle instance d'une addresse par defaut
     */
    public Addresse(){
        // On initialise cet entier à -1
        this.numero = -1;
    }

    
    /**
     * Construit une nouvelle instance d'une addresse précise de la memoire
     * 
     * @param numero le numero de l'addresse à créé
     */
    public Addresse(int numero){
        this.numero = Constante.modulo(numero);
    }

    /**
     * Retourne l'addresse précédente de l'adrrese actuelle
     * 
     * @return une addresse
     */

    public Addresse addressePrecedente(){
        return Addresse.addressePrecedente(this);
    }

    /**
     * Retourne l'addresse précédente d'une addresse donnée
     * 
     * @param addresse
     * @return une addresse memoire
     */
    public static Addresse addressePrecedente(Addresse addresse){
        return new Addresse(addresse.getNumero() - 1);
    }

    

    /**
     * Retourne l'addresse suivante de l'addresse actuelle
     * 
     * @return une addresse memoire
     */
    public Addresse addresseSuivante(){
        return Addresse.addresseSuivante(this);
    }

    /**
     * Retourne l'addresse suivante d'une addresse donnee
     * 
     * @param addresse
     * @return une addresse memoire
     */
    public static Addresse addresseSuivante(Addresse addresse){
        return new Addresse(addresse.numero + 1);
    }


    /**
     * Additionne deux addresses memoires
     * 
     * @param addresse1
     * @param addresse2
     * @return une addresse memoire
     */
    public static Addresse addition(Addresse addresse1, Addresse addresse2){
        return new Addresse(addresse1.numero + addresse2.numero);
    }

    /**
     * Soustrait deux addresses memoires
     * 
     * @param addresse1
     * @param addresse2
     * @return une addresse memoire
     */
    public static Addresse soustraction(Addresse addresse1, Addresse addresse2) {
        return new Addresse(addresse1.numero - addresse2.numero);
    }
    
    /**
     * Additionne l'adresse memoire actuelle avec un nombre
     * 
     * @param nombre le nombre avec lequel additionner
     */
    public Addresse addition(int nombre) {
        return new Addresse(this.numero + nombre);
    }

    @Override
    public String toString() {
        return String.valueOf(numero);
    }

}
