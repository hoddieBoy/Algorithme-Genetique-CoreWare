package modele.memoire;


import modele.AbstractModel;
import modele.memoire.composants.Addresse;
import modele.memoire.composants.FileProcessus;
import modele.redcode.enumeration.Mode;
import modele.redcode.enumeration.Opcode;
import modele.redcode.instruction.Instruction;
import modele.redcode.instruction.Operande;

import static application.Constante.*;

import java.util.LinkedList;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;


/**
 * Classe representant l'interpreteur d'une memoire virtuel
 * 
 * <p>
 *  Un interpreteur est caractérisé par
 * </p>
 * <ul>
 *  <li>Une reference vers la memoire à excecuter></li>
 *  <li>Une file de processus en attentes d'excecution</li>
 * </ul>
 * 
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 * @version 1.0
 */
@Getter
@Setter
public class Interpreteur extends AbstractModel {
    
    /**
     * La memoire associé à l'interpreteur
     * 
     * --Getter--
     * Retourne la memoire au quel est associé l'interpreteur
     * @return une memoire
     * 
     * --Setter--
     * Modifie la memoire de l'interpreteur
     * @param memoire la nouvelle memoire
     */
    private Memoire memoire;

    /**
     * La file d'attentes des processus
     * 
     * --Getter--
     * Retourne la file d'attentes des processus
     * @return la file d'attentes des processus
     * 
     * --Setter--
     * Modifie la file d'attentes des processus
     * @param fileAttentesProcessus la nouvelle file d'attentes des processus
     */
    private FileProcessus fileAttentesProcessus;


    /**
     * Construit une nouvelle instance d'un interpreteur
     * 
     * @param memoire la memoire au quel on associera l'interpreteur
     */
    public Interpreteur(Memoire memoire) {
        this.memoire = memoire;
        this.fileAttentesProcessus = new FileProcessus();
    }

    /**
     * Ajoute un processus a la queue de la file d'attentes
     * @param processus le nouveau processus
     */
    public void addProcessus(int processus) {
        fileAttentesProcessus.add(new Addresse(processus));
    }

    /**
     * Ajoute un processus a la queue de la file d'attentes
     * @param processus le nouveau processus
     */
    public void addProcessus(Addresse processus) {
        fileAttentesProcessus.add(processus);
    }
    
    /**
     * Vide complétement la file d'attentes des procesus
     */
    public void viderFileAttentesProcessus() {
        fileAttentesProcessus.clear();
    }

    /**
     * Lance l'interpretation du processus en tete de file 
     */
    public void interpreter() {
        notifyObserver();
        Addresse addresseAbsolue = fileAttentesProcessus.pop();
        
        Addresse processusSuivant = null;
        if (addresseAbsolue.getNumero() != -1) {
            Opcode opcode = memoire.lecture(addresseAbsolue).getInstruction().getOpcode();
                    notifyObserver(addresseAbsolue.getNumero(), 1);

        switch (opcode) {

            case MOV:
                processusSuivant = move(addresseAbsolue);
                break;

            case ADD:
                processusSuivant = add(addresseAbsolue);
                break;

            case JMP:
                processusSuivant = jmp(addresseAbsolue);
                break;

            case DAT:
                processusSuivant = new Addresse();
                break;

            case JMZ:
                processusSuivant = jmz(addresseAbsolue);
                break;

            case CMP:
                processusSuivant = cmp(addresseAbsolue);
                break;

            case DJZ:
                processusSuivant = djz(addresseAbsolue);
                break;

            case DJN:
                processusSuivant = djn(addresseAbsolue);
                break;

            case JMN:
                processusSuivant = jmn(addresseAbsolue);
                break;

            case SLT:
                processusSuivant = slt(addresseAbsolue);
                break;

            case SPL:
                processusSuivant = addresseAbsolue.addresseSuivante();
                this.addProcessus(spl(addresseAbsolue));
                break;

            case SUB:
                processusSuivant = sub(addresseAbsolue);
                break;

            default:
                break;

        }

        this.addProcessus(processusSuivant);

        }
        

    }

    /**
     * Calcule l'addresse associé à l'operande
     * 
     * @return l'addresse associé à l'operande
     */
    public int calculAddresse(Operande operande, int adresse) {
        int result = 0;

        int tmp = modulo(adresse + operande.getValeur());
        Instruction tmpInstruction = memoire.lecture(tmp).getInstruction();
        switch (operande.getMode()) {

            case IMMEDIAT:
                result = adresse;
                break;

            case DIRECT:
                result = adresse + operande.getValeur();
                break;

            case A_INDIRECT:

                result = adresse + tmpInstruction.getOperandeA().getValeur();
                break;

            case B_INDIRECT:
                result = adresse + tmpInstruction.getOperandeB().getValeur();
        }
        return modulo(result);
    }

    /**
     * Calcule l'addresse associé à l'operande
     * 
     * @return l'addresse associé à l'operande
     */
    public Addresse calculAddresse(Operande operande, Addresse adresse) {
        Addresse result = null;

        Addresse tmp = adresse.addition(operande.getValeur());

        Instruction tmpInstruction = memoire.lecture(tmp).getInstruction();
        switch (operande.getMode()) {

            case IMMEDIAT:
                result = adresse;
                break;

            case DIRECT:
                result = tmp;
                break;

            case A_INDIRECT:

                result = adresse.addition(tmpInstruction.getOperandeA().getValeur());
                break;

            case B_INDIRECT:
                result = adresse.addition(tmpInstruction.getOperandeB().getValeur());
        }
        return result;
    }

    /**
     * Copie la case memoire 
     */
    private Addresse move(Addresse adresseInstruction) {
        Instruction instruction = memoire.lecture(adresseInstruction).getInstruction();
        Operande opA = instruction.getOperandeA();
        Operande opB = instruction.getOperandeB();
        Addresse adresseM = calculAddresse(opB, adresseInstruction);
        
        if (opA.getMode() == Mode.IMMEDIAT) {
            memoire.lecture(adresseM).getInstruction().getOperandeB().setValeur(opA.getValeur());
        } 
        else {
            Addresse adresseR = calculAddresse(opA, adresseInstruction);
            memoire.ecriture(new Instruction(memoire.lecture(adresseR).getInstruction()), adresseM);
        }

        return (adresseInstruction.addresseSuivante());
    }

    private Addresse add(Addresse adresseInstruction) {
        Instruction instruction = memoire.lecture(adresseInstruction).getInstruction();
        Operande opA = instruction.getOperandeA();
        Operande opB = instruction.getOperandeB();
        
        Addresse adresseM = calculAddresse(opB, adresseInstruction);
        Instruction instructionM = memoire.lecture(adresseM).getInstruction();
        int valeurA = instructionM.getOperandeA().getValeur();
        int valeurB = instructionM.getOperandeB().getValeur();

        if (opA.getMode() == Mode.IMMEDIAT) {
            instructionM.getOperandeB().setValeur(valeurB + opA.getValeur());
        } 
        else {
            Addresse adresseR = calculAddresse(opA, adresseInstruction);
            Instruction operationR = memoire.lecture(adresseR).getInstruction();
            instructionM.getOperandeA().setValeur(valeurA + operationR.getOperandeA().getValeur());
            instructionM.getOperandeB().setValeur(valeurB + operationR.getOperandeB().getValeur());

        }

        return (adresseInstruction.addresseSuivante());
    }

    private Addresse sub(Addresse adresseInstruction) {
        
        Instruction instruction = memoire.lecture(adresseInstruction).getInstruction();
        Operande opA = instruction.getOperandeA();
        Operande opB = instruction.getOperandeB();
        Addresse adresseM = calculAddresse(opB, adresseInstruction);
        Instruction instructionM = memoire.lecture(adresseM).getInstruction();
        int valeurA = instructionM.getOperandeA().getValeur();
        int valeurB = instructionM.getOperandeB().getValeur();

        if (opA.getMode() == Mode.IMMEDIAT) {
            instructionM.getOperandeB().setValeur(valeurB - opA.getValeur());
        } else {
            Addresse adresseR = calculAddresse(opA, adresseInstruction);
            Instruction operationR = memoire.lecture(adresseR).getInstruction();
            instructionM.getOperandeA().setValeur(valeurA - operationR.getOperandeA().getValeur());
            instructionM.getOperandeB().setValeur(valeurB - operationR.getOperandeB().getValeur());

        }

        return (adresseInstruction.addresseSuivante());
    }

    private Addresse jmp(Addresse adresseInstruction) {
        
        Instruction instruction = memoire.lecture(adresseInstruction).getInstruction();
        return (adresseInstruction.addition(instruction.getOperandeA().getValeur()));
    }

    private Addresse jmz(Addresse adresseInstruction) {
        
        Instruction instruction = memoire.lecture(adresseInstruction).getInstruction();
        Operande opA = instruction.getOperandeA();
        Operande opB = instruction.getOperandeB();
        if (opB.getValeur() == 0) {
            return (adresseInstruction.addition(opA.getValeur()));
        }
        return adresseInstruction.addresseSuivante();
    }

    private Addresse jmn(Addresse adresseInstruction) {
        
        Instruction instruction = memoire.lecture(adresseInstruction).getInstruction();
        Operande opA = instruction.getOperandeA();
        Operande opB = instruction.getOperandeB();
        if (opB.getValeur() != 0) {
            return (adresseInstruction.addition(opA.getValeur()));
        }
        return adresseInstruction.addresseSuivante();
    }

    private Addresse djn(Addresse adresseInstruction) {
        
        Instruction instruction = memoire.lecture(adresseInstruction).getInstruction();
        Operande opA = instruction.getOperandeA();
        Operande opB = instruction.getOperandeB();
        if (opB.getValeur() - 1 != 0) {
            return (adresseInstruction.addition(opA.getValeur()));
        }
        return adresseInstruction.addresseSuivante();
    }

    private Addresse djz(Addresse adresseInstruction) {
        
        Instruction instruction = memoire.lecture(adresseInstruction).getInstruction();
        Operande opA = instruction.getOperandeA();
        Operande opB = instruction.getOperandeB();
        if (opB.getValeur() - 1 == 0) {
            return (adresseInstruction.addition(opA.getValeur()));
        }
        return adresseInstruction.addresseSuivante();
    }

    private Addresse cmp(Addresse adresseInstruction) {
        int jump;
        
        Instruction instruction = memoire.lecture(adresseInstruction).getInstruction();
        Operande opA = instruction.getOperandeA();
        Operande opB = instruction.getOperandeB();
        if (opA.getMode() == Mode.IMMEDIAT) {
            Addresse adresseM = calculAddresse(opB, adresseInstruction);
            Instruction instructionM = memoire.lecture(adresseM).getInstruction();
            int valeurA = instructionM.getOperandeA().getValeur();
            int valeurB = instructionM.getOperandeB().getValeur();
            jump = (valeurA == opA.getValeur() && valeurB == opB.getValeur()) ? 1 : 0;
        } else if (opB.getMode() == Mode.IMMEDIAT) {
            Addresse adresseM = calculAddresse(opB, adresseInstruction);
            Instruction instructionM = memoire.lecture(adresseM).getInstruction();
            int valeurB = instructionM.getOperandeB().getValeur();
            jump = valeurB == opB.getValeur() ? 1 : 0;
        } else {
            Addresse adresseM = calculAddresse(opB, adresseInstruction);
            Instruction instructionM = memoire.lecture(adresseM).getInstruction();
            Addresse adresseR = calculAddresse(opA, adresseInstruction);
            Instruction operationR = memoire.lecture(adresseR).getInstruction();
            jump = instructionM.equals(operationR) ? 1 : 0;
        }

        return (adresseInstruction.addition(1 + jump));

    }

    
    private Addresse slt(Addresse adresseInstruction) {
        int jump;
        
        Instruction instruction = memoire.lecture(adresseInstruction).getInstruction();
        Operande opA = instruction.getOperandeA();
        Operande opB = instruction.getOperandeB();
        if (opA.getMode() == Mode.IMMEDIAT) {
            Addresse adresseM = calculAddresse(opB, adresseInstruction);
            Instruction instructionM = memoire.lecture(adresseM).getInstruction();
            int valeurA = instructionM.getOperandeA().getValeur();
            int valeurB = instructionM.getOperandeB().getValeur();
            jump = opA.getValeur() < valeurA && opA.getValeur() < valeurB ? 1 : 0;
        } else {
            Addresse adresseM = calculAddresse(opB, adresseInstruction);
            Instruction instructionM = memoire.lecture(adresseM).getInstruction();
            Addresse adresseR = calculAddresse(opA, adresseInstruction);
            Instruction operationR = memoire.lecture(adresseR).getInstruction();
            jump = operationR.getOperandeB().getValeur() < instructionM.getOperandeB().getValeur() ? 1 : 0;

        }

        return (adresseInstruction.addition(1 + jump));

    }

    private Addresse spl(Addresse adresseInstruction) {
        Instruction instruction = memoire.lecture(adresseInstruction).getInstruction();
        Operande opA = instruction.getOperandeA();
        
        return new Addresse(opA.getValeur());
    }


}
