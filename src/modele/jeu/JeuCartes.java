package modele.jeu;

public interface JeuCartes {

    /**
     * Tire une carte et met à jour la partie
     * @return boolean
     */
    boolean tirer();

    /**
     * Vérifie que le nombre de tours de la partie est inférieur au nombre maximum de tours
     * @return boolean nombre de tours > maximum de tours
     */
    boolean estTermine();

    /**
     * Sauvegarde le score du joueur dans le tableau des scores
     */
    void sauvegarder();
}
