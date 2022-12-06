package modele.memoire;

import modele.AbstractModel;
import modele.memoire.composants.Cellule;
import modele.redcode.instruction.Instruction;
import modele.memoire.composants.Addresse;

import static application.Constante.modulo;

import java.util.Collection;
import java.util.List;

import static application.Constante.TAILLE_MEMOIRE;
import static application.Constante.LARGEUR;


import lombok.Getter;
import lombok.Setter;

/**
 * 
 * <b>Classe representante une memoire virtuel pour la machine virtuelle</b>
 * 
 * <p>
 *  La memoire virtuel est le plateau sur lequel se deroule le combat entre les programmes.
 *  elle est constitué de cellule memoire possedant une adresse unique. On peut notamment
 * effectué l'écriture et la lecture d'une case Memoire. Sa caractéristique particulière est
 * quelle fonctionne de façon circulaire
 * </p>
 * 
 * <p>
 *  La version actuelle de l'application a une taille memoire de {@link application.Constante#TAILLE_MEMOIRE}
 * </p>
 * 
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 * @version 1.0
 */

@Getter
@Setter
public class Memoire extends AbstractModel {

    /**
     * Tableau contenant representante les cellules d'une memoire
     * 
     * --Getter--
     * Retourne le tableau de toutes les cellules memoires
     * @return un tableau de cellules
     * 
     * --Setter--
     * Modifie le tableau de cellules de memoire
     * @param cellulesMemoires le nouveau tableau de cellules memoires
     */
    private Cellule[] cellulesMemoires;

    /**
     * Construit une nouvelle instance d'une memoire
     */
    public Memoire() {

        this.cellulesMemoires = new Cellule[TAILLE_MEMOIRE];
    }

    /**
     * Lit et retourne la valeur situe à une addresse indiqué
     * 
     * @param addresse le numero de l'addresse à lire
     */
    public Cellule lecture(int addresse) {

        return cellulesMemoires[addresse];
    }


    /**
     * Initialise les cellules memoires de la memoires
     * 
     * <p>
     *  Une valeur par defaut est mise dans l'ensemble des cases memoires.
     *  Cette valeur est l'instruction "DAT $ 0 $ 0"
     * </p>
     */
    public void initMemoire() {

        for (int i = 0; i < TAILLE_MEMOIRE; i++) {

            cellulesMemoires[i] = new Cellule(i);
            notifyObserver(i, -1);
        }
    }

    /**
     * Lit et retourne la valeur situe à une addresse indiqué
     * 
     * @param addresse l'addresse à lire
     */
    public Cellule lecture(Addresse addresse) {
        return lecture(addresse.getNumero());
    }
    
    /**
     * Ecrit une instruction à l'addresse indique
     * 
     * @param instruction Une instruction à écrire
     * @param adresse l'adresse où écrie l'instruction
     */
    public void ecriture(Instruction instruction, Addresse adresse) {
        ecriture(instruction, adresse.getNumero());
    }

    /**
     * 
     * Ecrit une instruction à l'addresse dit
     * 
     * @param instruction Une instruction à écrire
     * @param addresse le numero de l'addresse à écrire
     */
    public void ecriture(Instruction instruction, int addresse) {
        cellulesMemoires[addresse].setInstruction(instruction);
        notifyObserver(addresse, 0);

    }

    /**
     * Ecrit une collection d'instruction en memoire à partir de l'adresse indiqué
     * 
     * @param instructions la collection d'instruction à ecrire
     * @param adresse l'adresse du debut de l'écriture
     */
    public void ecriture(Collection<Instruction> instructions, int adresse) {

        Addresse adresse1 = new Addresse(adresse);
        for (Instruction instruction : instructions) {
            ecriture(instruction, adresse1);
            adresse1 = adresse1.addresseSuivante();
        }
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        for (Cellule cellule : cellulesMemoires) {
            sb.append(cellule.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
