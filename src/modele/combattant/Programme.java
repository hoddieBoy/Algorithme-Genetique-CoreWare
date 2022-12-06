package modele.combattant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import modele.redcode.instruction.Instruction;

/**
 * <b>Class representante un programme écrit en redcode</b>
 * 
 * <p>
 *  Un programme est une liste d'instruction successives en redcode
 *  Chaque lisgne du programme doivent garder la structure d'une instruction déja
 *  prédéfinie
 * <p>
 * 
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 * @version 1.0
 * 
 * @see modele.combattant.Warrior#programme
 * @see modele.combattant.Warrior#Warrior(Programme programme)
 * @see genetique.Croisement#croisementProgramme(Programme, Programme)
 * @see genetique.Croisement#croisementProgrammes(Programme, Programme)
 * @see genetique.Mutation#mutationProgramme(Programme)
 * @see genetique.Generateur#generate(List)
 * @see genetique.Mutation#generate(List, int)
 */

@Getter
@Setter
@EqualsAndHashCode
public class Programme {

    /**
     * Liste des instructions de redCode
     * 
     * --Getter--
     * Retourne la liste des instructions associé au programme
     * @return Liste d'instruction
     * 
     * --Setter--
     * Modifie la liste des instructions en redcode
     * @param listeInstructions la nouvelle liste d'instruction
     */
    private List<Instruction> listeInstructions;

    
    /**
     * Construit une nouvelle instance d'un programme
     * 
     * @param  listeInstructions tabInstructions
     */
    public Programme(List<Instruction> listeInstructions) {
        this.listeInstructions = new ArrayList<>();
        this.listeInstructions.addAll(listeInstructions);
    }

    public Programme() {
        this.listeInstructions = new ArrayList<>();
    }

    /**
     * Construit une nouvelle instance d'un programme à partir d'un autre programme
     * 
     * @param programme
     */
    public Programme(Programme programme) {
        this();
        programme.listeInstructions.forEach(i -> this.addInstruction(new Instruction(i)));
    }

    /**
     * Construit une nouvelle instance d'un autre programme à partir d'un fichier 
     * @param fichier
     */
    public Programme(String fichier) {

        try {
            this.listeInstructions = new ArrayList<>();
            File file = new File(fichier);
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith(";")) {
                    this.listeInstructions.add(new Instruction(line));

                }
            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    /**
     * Retourne l'operation se trouvant à la position index
     * 
     * @param index l'index de l'operation
     */
    public Instruction getOperation(int index) {
        return this.listeInstructions.get(index);
    }

    /**
     * Modifie l'operation se trouvant à la position index
     * 
     * @param index     l'index de l'operation
     * @param operation la nouvelle operation
     */
    public void setInstruction(int index, Instruction operation) {
        listeInstructions.set(index, operation);
    }

    /**
     * Ajoute une instruction à la liste des instructions
     * 
     * @param <Instruction> operation
     */
    public void addInstruction(Instruction operation) {
        this.listeInstructions.add(operation);
    }

    /**
     * Retirer une instruction de la liste des instructions
     * 
     * @param <Instruction> operation
     */
    public void removeInstruction(Instruction operation) {
        this.listeInstructions.remove(operation);
    }

    /**
     * Retourne la taille du programme
     * <p>
     *  La taille du programme est égale au nombre d'instructions contenus dans le programme
     * <p>
     * @return un entier
     */
    public int taille() {
        return this.listeInstructions.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.listeInstructions.size(); i++) {
            sb.append(this.listeInstructions.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}