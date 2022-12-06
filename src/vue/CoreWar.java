package vue;

import javax.swing.*;

import java.awt.event.*;

import controleur.Controleur;
import observeur.Observer;
import vue.actions.QuitterPartie;
import vue.composants.Menu;
import vue.ecrans.EcranAccueil;
import vue.ecrans.EcranJeu;
import lombok.Getter;

/**
 * Classe représentant la fenêtre principale de la vue
 * 
 * @author DOUMBOUYA Sekou <a href="mailto:sekou.doumbouya@etu.unicaen.fr>sekou.doumbouya@etu.unicaen.fr</a>
 * 
 * @version 1.0
 */
@Getter
public class CoreWar extends JFrame implements Observer, ElementVue{


    /**
     * Le controleur auquel est associé la fenetre
     * 
     * --Getter--
     * Retourne le controleur associé 
     * @return un controleur
     */
    private Controleur controleur;

    /**
     * L'ecran principale de la partie
     * 
     * --Getter--
     * Retourne l'ecran principale de la partie
     * @return EcranJeu
     */
    private EcranJeu ecranJeu;

    /**
     * L'ecran d'accueil de l'application
     * 
     * --Getter--
     * Retourne l'ecran d'accueil de l'application
     * @return EcranAccueil
     */
    private EcranAccueil ecranAccueil; 

    /**
     * 
     */
    private Timer timer;

    /**
     * Construit la fenetre de l'application
     * @param controleur le controleur du jeu
     */
    public CoreWar(Controleur controleur) {

        super();
        this.controleur = controleur;
        this.ecranJeu = new EcranJeu(this);
        this.ecranAccueil = new EcranAccueil(this, "Images/coreWare.png");

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                if (controleur.getPartie() == 1600 || controleur.isOver()) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Partie terminé veuillez recharger l'ensemble");
                }
                else {
                    controleur.excecute();

                }
            }
        };
        this.timer = new Timer(70, taskPerformer);

        timer.setRepeats(true);


    }

    

    @Override
    public void initialiserEvenements() {
        addWindowListener(new QuitterPartie(this));
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

    }

    @Override
    public void buildComposant() {
        setTitle("Fenetre principale du jeu Corewar");

        setSize(1250, 980);

        setLocationRelativeTo(null);
        
        Menu menu = new Menu(this);
        menu.build();

        setJMenuBar(menu.getMenuBar());

        ecranJeu.build();
        ecranAccueil.build();
        setContentPane(ecranAccueil);
        setVisible(true);
        
    }
    

    @Override
    public void update(int index, int etat) {

        ecranJeu.getPlateau().modifierCasesMemoire(index, etat, controleur.getTour());

    }



    @Override
    public void update(Object obj) {
        ecranJeu.getZonesInformation().setScoreJoueur(1, controleur.getScore1());
        ecranJeu.getZonesInformation().setScoreJoueur(2, controleur.getScore2());
    }

}