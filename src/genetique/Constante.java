package genetique;

/**
 * Classe final représentant la constande de l'algorithme génétique
 */
public final class Constante {

     /** Coefficient de la mutation d'une instruction */
    public static final double COEFFICIENT_MUTATION_INSTRUCTION = 0.25;
    
    /** Coefficient de la mutation d'une opérande */
    public static final double COEFFICIENT_MUTATION_OPERANDE = 0.3;
    
    /** Coefficient du croisement */
    public static final double COEFFICIENT_CROISEMENT = 0.7;

     /** Coefficient de la mutation */
    public static final double COEFFICIENT_MUTATION = 0.1; 

    /** Le rang maximal de la constante */
    public static final int RANG_MAX = 20; 
    
    private Constante(){}

    


}
