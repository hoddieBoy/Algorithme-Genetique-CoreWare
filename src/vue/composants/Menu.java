package vue.composants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import lombok.Getter;
import vue.CoreWar;
import vue.ElementVue;
import vue.actions.GenererRedCode;
import vue.actions.OuvrirFichier;

public class Menu implements ElementVue, ActionListener{

    @Getter
    private JMenuBar menuBar;
    private CoreWar coreWar;
    

    public Menu(CoreWar coreWar) {
        this.coreWar = coreWar;
        this.menuBar = new JMenuBar();
    }

    public void creerMenuBar() {

        JMenu menu = new JMenu("menu");
        JMenu aide = new JMenu("Aide ?");
        JMenuItem propos = new JMenuItem("A propos");
        aide.add(propos);
        propos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = "Bonjour !\n";
                String presentation = "Cette fênetre de jeu CoreWar est facile à manipuler\n";
                String suite1 = "Il vous est mis à votre disposition deux fênetres principales :\n";
                String suite2 = "- Ecran d'accueil\n- Ecran de jeu\n";
        
                String suite3 = "Pour accéder à la fênetre de jeu à partir de l'écran d'accueil,\ntaper sur le boutton (Lancer Jeu), sinon taper (Quitter Jeu) pour quitter\n";
                String suite4 = "Sur la fênetre de jeu, le plateau de jeu et cinq(5) buttons sont placés :\n";
                String suite5 = "- Jouer \t\t (qui permet de lancer le jeu après chargement)\n- Pause (qui permet de mettre en pause)\n- Chargement (qui permet de charger les warriors/guerriers)\n- Reinitialiser (qui permet de réinitialiser le plateau de jeu)\n- Quitter (qui permet de quitter la partie)\n";
                JOptionPane.showMessageDialog(null,info + presentation + suite1 + "\n" + suite2 + "\n" + suite3 + "\n" + suite4 + "\n" + suite5,"Information",JOptionPane.INFORMATION_MESSAGE);
            }
        });
       
        
        JMenuItem menuItemChargerWarrior = new JMenuItem("Charger un warrior");
        menuItemChargerWarrior.addActionListener(new OuvrirFichier(coreWar.getControleur()));
        JMenuItem menuItemReinitialiser = new JMenuItem("Reinitialiser");
        JMenuItem menuItemGenererRedCode = new JMenuItem("Generer un programme");
        menuItemGenererRedCode.addActionListener(new GenererRedCode(coreWar.getControleur()));
        JMenuItem menuItemQuitter = new JMenuItem("Quitter");

        menuBar.add(menu);

        menu.add(menuItemChargerWarrior);
        menu.add(menuItemGenererRedCode);
        menu.add(menuItemReinitialiser);
        menu.add(menuItemQuitter);
       
        menuBar.add(aide);

}
   



    @Override
    public void initialiserEvenements() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void buildComposant() {
        creerMenuBar();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
