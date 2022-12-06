package vue.actions;

import java.awt.event.*;

import javax.swing.JOptionPane;

import vue.CoreWar;

/**
 * Classe representant une action permettant de quitter le jeu
 * 
 * @author DOUMBOUYA Sekou <a href="mailto:sekou.doumbouya@etu.unicaen.fr"> sekou.doumbouya@etu.unicaen.fr </a>
 * @version 1.0
 */
public class QuitterPartie implements ActionListener, WindowListener {
    
    /* Attributs de la classe */
    private CoreWar frame;

    /**
     * Constructeur de la classe
     * @param frame la fenetre du niveau supérieur
     */
    public QuitterPartie(CoreWar frame) {
        this.frame = frame;
    }

    /**
     * Arrête le jeu
     */
    private void arreterTout() {

        int result =  JOptionPane.showConfirmDialog(frame.getContentPane(), "Confirmez la fermeture", "Attention Fermeture", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.out.println("Fin de l'excecution, on ferme tout. Bonne journée.");
            this.frame.getTimer().stop();
            this.frame.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        arreterTout();
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
      // TODO document why this method is empty
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
                arreterTout();

        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
