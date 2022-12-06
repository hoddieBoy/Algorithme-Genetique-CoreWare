package vue.composants.boutons;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import vue.ElementVue;

import java.awt.*;
import static vue.Constante.*;

/** 
 * Classe abstraite dont heriteront tous les boutons de la frame
 * 
 * @author DOUMBOUYA Sekou <a href="mailto:sekou.doumbouya@etu.unicaen.fr"> sekou.doumbouya@etu.unicaen.fr </a>
 * @version 1.0
*/
public abstract class AbstractBouton extends JButton implements ElementVue {

    /** 
     * Le nom d'un bouton 
     * */
    protected String nomBouton;

    /** 
     * Couleur de fond de bouton 
    */
    protected Color fondColor;

    /**
     * Construit une nouvelle instance d'un bouton abstrait
     * @param nom
     * @param fondColor
     */
    protected AbstractBouton(String nom, Color fondColor) {
        super(nom);
        this.fondColor = fondColor;
    }

    @Override
    public void buildComposant() {
        setPreferredSize(new Dimension(LARGEUR_BOUTON, HAUTEUR_BOUTON));
        setBackground(fondColor);
        setBorder(BorderFactory.createRaisedSoftBevelBorder());
    }

}
