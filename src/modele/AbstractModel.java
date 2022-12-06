package modele;

import java.util.ArrayList;

import observeur.Observable;
import observeur.Observer;

/**
 * Classe abstraite du modèle
 */
public abstract class AbstractModel implements Observable{
    private ArrayList<Observer> listObserver = new ArrayList<>();

    // Implémentation du pattern observer
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }

    public void removeObserver() {
        listObserver = new ArrayList<>();
    }

    public void notifyObserver(int index, int etat) {
        for (Observer obs : listObserver) {
            obs.update(index, etat);

        }
    }

    public void notifyObserver() {
        for (Observer obs : listObserver) {
            obs.update(this);
        }
    }
}
