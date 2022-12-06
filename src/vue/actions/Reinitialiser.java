package vue.actions;

import java.awt.event.*;

import controleur.Controleur;

public class Reinitialiser implements ActionListener{

    private Controleur controleur;

    public Reinitialiser(Controleur controleur) {
        this.controleur = controleur;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        this.controleur.reinitialise();
        
    }
    
}
