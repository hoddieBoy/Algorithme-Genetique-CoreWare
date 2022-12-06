package vue.actions;

import java.awt.event.*;

import javax.swing.JOptionPane;

import controleur.Controleur;
import genetique.Generateur;
import modele.combattant.Programme;
import modele.combattant.Warrior;

public class GenererRedCode implements ActionListener{

    private Controleur controleur;

    public GenererRedCode(Controleur controleur) {
        this.controleur = controleur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        int nombre = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrer la taille de la population de base", 
                "Generer redcode"));
        
        Programme programme = Generateur.generateProgramme(Generateur.genererPopulationBase(nombre));

        int warrior = Integer.parseInt(
                    JOptionPane.showInputDialog(null,
                                "Veuillez entrer le numero du warrior(1 ou 2) à charger ")
        );
        
        if (warrior == 1) {
            controleur.setPremierCombatant(new Warrior(programme));
        }
        else {
            controleur.setDeuxiemeCombatant(new Warrior(programme));
        }
        controleur.getInterpreteur().getMemoire().initMemoire();
        controleur.chargementWarriors();

        
    }
    
}
