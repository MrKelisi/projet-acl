package modele.highscores;

import modele.joueurs.Joueur;

import java.util.ArrayList;
import java.util.Iterator;

public class Tableau implements Iterable<Score> {
    private static final int MAX_SCORES = 10;
    private static Tableau instance;
    private ArrayList<Score> scores;

    /**
     * Tableau des scores, chargé à partir d'un fichier
     * @see PersistanceScores
     */
    private Tableau() {
        scores = PersistanceScores.charger();
    }

    /**
     * Retourne l'instance du singleton Tableau et, si elle n'existe pas, la crée
     * @return instance
     */
    public static Tableau getInstance() {
        if (instance == null) {
            instance = new Tableau();
        }
        return instance;
    }

    /**
     * Ajoute un nouveau score au tableau des scores à la date d'exécution
     * @param joueur Joueur
     * @param score Score du joueur
     */
    public void ajouter(Joueur joueur, int score) {
        int i = 0;
        for(Score sc : scores) {
            if(sc.getScore() > score) {
                break;
            }
            i++;
        }
        scores.add(i, new Score(joueur, score));

        if(scores.size() > MAX_SCORES) {
            scores.remove(scores.size() - 1);
        }

        PersistanceScores.sauvegarder(this);
    }

    @Override
    public Iterator<Score> iterator() {
        return scores.iterator();
    }
}
