package genetique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.util.List;
import java.util.Random;
import java.util.Set;

import java.util.TreeSet;
import java.util.stream.IntStream;

import modele.combattant.Programme;
import modele.redcode.enumeration.Mode;
import modele.redcode.enumeration.Opcode;
import modele.redcode.instruction.Instruction;
import modele.redcode.instruction.Operande;

import static genetique.Constante.*;
import static genetique.Croisement.croisementProgrammes;

import static genetique.Mutation.mutationProgramme;

/**
 * Classe représentant le générateur de l'algorithme génétique
 * 
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 * @version 1.0
 */
public final class Generateur {

    private static Random random = new Random();
    private static Evaluation evaluateur = new Evaluation();
    public static HashMap<Programme, Double> save = new HashMap<>();
    public static int tour = 0;

    private Generateur() { }

    public static List<Programme> generate(List<Programme> programmesBase) {
        tour += 1;
        List<Programme> programmes = new ArrayList<>();
        int tailleBase = programmesBase.size();

            int choix = 0;
            Programme p;
            double rang;
            while (programmes.size() < ((double) tailleBase / 2)) {
                choix = random.nextInt(tailleBase);
                p = programmesBase.get(choix);
                
                if (save.containsKey(p)) {
                    rang = save.get(p);
                }
                else {
                    rang = (double) evaluateur.rangProgramme(p) / (double) RANG_MAX;
                    save.put(p, rang);

                }
                
            
                if (random.nextDouble() < rang || random.nextDouble() > 0.7) {
                    programmes.add(p);
                }

            }

        
    
        

        List<Programme> results = new ArrayList<>();
        Programme p1;
        Programme p2;
        Set<Programme> tmpProgrammes = new TreeSet<>(new ComparateurProgramme());
        List<Integer> parents = new ArrayList<>();
        IntStream.range(0, programmes.size()).forEach(parents::add);
        tmpProgrammes.addAll(programmes);
        while (!parents.isEmpty()) {
            Collections.shuffle(parents);
            p1 = programmes.get(parents.get(0));
            p2 = programmes.get(parents.get(parents.size() - 1));
            if (random.nextDouble() < COEFFICIENT_CROISEMENT) {
                tmpProgrammes.addAll(croisementProgrammes(p1, p2));
            }
            if (parents.size() > 1) {
                parents.remove(parents.size() - 1);
            }
            parents.remove(0);

        }
        results.addAll(tmpProgrammes);
        for (int i = 0; i < results.size(); i++) {
            if (random.nextDouble() <= COEFFICIENT_MUTATION) {
                results.set(i, mutationProgramme(results.get(i)));
            }
        }
        System.out.println(results.size()+",");
        return results;

    }

    /**
     * Génère une liste de programme
     * @param programmesBase le programe de base
     * @param nbIteration le nombre d'itération
     */
    public static Programme generateProgramme(List<Programme> programmesBase) {
        if (programmesBase.size() == 1) {
            Programme p = programmesBase.get(0);
            double rang;
            if (save.containsKey(p)) {
                rang = save.get(p);
            }
            else {
                rang = (double) evaluateur.rangProgramme(p) / (double) RANG_MAX;
            }

            if (rang >= 0.8) {
                return p;
            }
            programmesBase.add(p);
            return generateProgramme(programmesBase);
        }
        List<Programme> nextGeneration = generate(programmesBase);
        return generateProgramme(nextGeneration);
    }


    /**
     * Genere une population de base alétaotire
     * @param taille lataille de la population
     */
    public static List<Programme> genererPopulationBase(int taille) {
        List<Programme> results = new ArrayList<>();
        Opcode [] opcodes = Opcode.values();
        Mode[] modes = Mode.values();
        Opcode opcode;
        Operande opA;
        Operande opB;
        int choix;
        for (int i = 0; i < taille; i++) {
            int longueur = 1+ random.nextInt(RANG_MAX/2);
            int j = 0;
            Programme programme = new Programme();
            while (j < longueur) {
                choix = random.nextInt(opcodes.length);
                opcode = opcodes[choix];
                choix = random.nextInt(modes.length);
                opA = new Operande(modes[choix], -longueur + random.nextInt(2*(longueur)+1));
                choix = random.nextInt(modes.length);
                opB = new Operande(modes[choix], -longueur + random.nextInt(2*(longueur)+1));
                programme.addInstruction(new Instruction(opcode, opA, opB));
                j++;
            }
            results.add(programme);
        }
        return results;
    }
}
