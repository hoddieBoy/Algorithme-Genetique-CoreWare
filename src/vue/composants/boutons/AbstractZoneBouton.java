package vue.composants.boutons;

import javax.swing.JPanel;

import lombok.Getter;
import vue.ElementVue;
import vue.CoreWar;


/**
 * Classe abstraite dont heriteront toutes les zones de boutons
 * 
 * @author KITSOUKOU Manne Emile <a href="mailto:22013393@etu.unicaen.fr">22013393@etu.unicaen.fr</a>
 * @version 1.0
 */
public abstract class AbstractZoneBouton extends JPanel implements ElementVue{
    

    /**
     * Ecran sur lequel seron associe les evenements des boutons
     */
    @Getter
    protected CoreWar ecran;

    /**
     * Construit une nouvelle instance abstraite d'une zone de boutons
     * 
     * @param ecran L'ecran du jeu
     */
    protected AbstractZoneBouton(CoreWar ecran) {
        this.ecran = ecran;
    }

    @Override
    public void initialiserEvenements() {
        // TODO Auto-generated method stub
        
    }


    
}
