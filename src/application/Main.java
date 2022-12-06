package application;


import controleur.Controleur;
import modele.combattant.Programme;
import modele.combattant.Warrior;
import modele.memoire.Interpreteur;
import modele.memoire.Memoire;
import vue.CoreWar;


public class Main {

    public static void main(String[] args) {
        Memoire memoire = new Memoire();
        memoire.initMemoire();


        Interpreteur interpreteur = new Interpreteur(memoire);
        Programme p = new Programme("Warriors/imp");
        Programme p1 = new Programme("Warriors/test2");
        Warrior pw = new Warrior(p);
        Warrior pw2 = new Warrior(p1);
        Controleur c = new Controleur(interpreteur, pw, pw2);
        CoreWar f = new CoreWar(c);
        f.build();

        memoire.addObserver(f);
        interpreteur.addObserver(f);

    }
}
