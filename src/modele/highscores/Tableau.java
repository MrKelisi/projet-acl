package modele.highscores;

import modele.joueurs.Joueur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Tableau implements Iterable<Score> {
    private static final int MAX_SCORES = 10;
    private static Tableau instance;
    private HashMap<Joueur, Score> playerScores;
    private ArrayList<Score> scores;

    /**
     * Tableau des scores, chargé à partir d'un fichier
     * @see PersistanceScores
     */
    private Tableau() {
        scores = new ArrayList<>();
        playerScores = new HashMap<>();
        for(Score score : PersistanceScores.charger()) {
            ajouter(score.getJoueur(), score);
        }
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
        ajouter(joueur, new Score(joueur, score));
    }

    private void ajouter(Joueur joueur, Score score) {
        if(playerScores.containsKey(joueur)) {
            Score oldScore = playerScores.get(joueur);
            if(score.getScore() <= oldScore.getScore()) {
                scores.remove(oldScore);
            }
            else {
                return;
            }
        }

        int i = 0;
        for(Score sc : scores) {
            if(sc.getScore() > score.getScore()) {
                break;
            }
            i++;
        }

        scores.add(i, score);
        playerScores.put(joueur, score);

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
