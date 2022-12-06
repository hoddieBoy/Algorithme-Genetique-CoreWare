package observeur;

/**
 * Interface observer
 * Observer est un modèle de conception comportementale qui permet à certains objets
 * de notifier d'autres objets sur les changements dans leur état. Il permet  de s'abonner
 * et de se désabonner à ces évènements pour tout objet qui implémente une interface d'abonné
 */
public interface Observer {
  void update(int index, int etat);

  void update(Object obj);
}