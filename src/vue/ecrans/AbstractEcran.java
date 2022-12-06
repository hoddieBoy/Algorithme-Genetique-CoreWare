package vue.ecrans;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import lombok.Getter;

import java.awt.BorderLayout;

import vue.ElementVue;
import vue.CoreWar;

/** 
 * Classe abstraite de l'écran du jeu 
 */ 
public abstract class AbstractEcran extends JPanel implements ElementVue{

    /**
     * La fenetre associé à cet ecran
     */
    @Getter
    protected CoreWar ecran;

    protected AbstractEcran(CoreWar ecran) {
        this.ecran = ecran;
    }

    @Override
    public void buildComposant() {
        // Layout utiliser par defaut
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLoweredSoftBevelBorder());
    }
    
    @Override
    public void initialiserEvenements() {
        // TODO Auto-generated method stub

    }
}
