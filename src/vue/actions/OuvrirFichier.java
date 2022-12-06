package vue.actions;



import java.awt.event.*;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import controleur.Controleur;
import modele.combattant.Programme;
import modele.combattant.Warrior;

public class OuvrirFichier implements KeyListener, ActionListener{


    private final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    private Controleur controleur;
    public OuvrirFichier(Controleur controleur) {
        this.controleur = controleur;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        int res = fc.showOpenDialog(fc.getParent());

        if (res == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            int warrior = Integer.parseInt(
                    JOptionPane.showInputDialog(null,
                                "Veuillez entrer le numero du warrior(1 ou 2) à charger ")
            );

            if (warrior == 1) {
                controleur.setPremierCombatant(new Warrior(new Programme(file.getAbsolutePath())));

            }
            else {
                controleur.setDeuxiemeCombatant(new Warrior(new Programme(file.getAbsolutePath())));
            }
            
            controleur.getInterpreteur().getMemoire().initMemoire();
            controleur.chargementWarriors();

            

        } 
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
