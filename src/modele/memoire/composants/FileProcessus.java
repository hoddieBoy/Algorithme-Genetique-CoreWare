package modele.memoire.composants;

import java.util.Collection;
import java.util.LinkedList;

public class FileProcessus extends LinkedList<Addresse> {
    


    /**
     * Mets totalement à jour la liste de processus
     * @param collectionsProcessus
     */
    public void setProcessus(Collection<Addresse> collectionsProcessus) {
        this.clear();
        this.addAll(collectionsProcessus);
    }

    /**
     * Vide toute la liste des processus et la retourne
     * @return processus
     */
    public FileProcessus removeAll() {
        FileProcessus processus = new FileProcessus();
        processus.addAll(this);
        this.clear();
        return processus;
    }
}
