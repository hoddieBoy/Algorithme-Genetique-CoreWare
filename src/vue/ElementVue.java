package vue;

/**
 * <b> Interface implementée par tout les composants de la vue </b>
 * 
 * <p>
 *  Tout composant de la vue doit avoir la capacité :
 * </p>
 * <ul>
 *  <li> initialiser ses événements</li>
 *  <li> Construire ses sous composants</li>
 *  <li> Et se construire lui même </li>
 * </ul>
 * 
 * @author DOUMBOUYA Sekou <a href="mailto:sekou.doumbouya@etu.unicaen.fr">sekou.doumbouya@etu.unicaen.fr</a>
 * @version 1.0
 * 
 * @see vue.CoreWar
 * @see vue.composants
 * @see vue.composants.boutons
 * @see vue.composants.plateau
 * @see vue.composants.boutons.AbstractBouton
 * @see vue.composants.boutons.AbstractZoneBouton
 */
public interface ElementVue {

    /**
     * Initialise les événements d'un composant de la vue
     */
    void initialiserEvenements();

    /**
     * Construit tous les sous composants d'un composant d'un élément de la vue
     */
    void buildComposant();


    /**
     * Construit totalement le composant de la vue
     */
    default void build() {
        initialiserEvenements();
        buildComposant();
    }
}
