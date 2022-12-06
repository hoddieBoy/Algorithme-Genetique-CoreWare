package observeur;

/**
 * Interface Observable qui est utilisépour créer des sous-classes que que d'autres parties du programme
 * peuvent observer. Lorsqu'un objet d'une telle sous-classe subit un changement, les classes d'observation 
 * sont notifiées.
 */
public interface Observable {
    public void addObserver(Observer obs);
    public void removeObserver();
    public void notifyObserver(int index, int etat);
}
