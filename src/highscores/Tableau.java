package highscores;

import files.ParseurHighscores;
import files.SauverHighscores;

import java.util.ArrayList;
import java.util.Iterator;

public class Tableau implements Iterable<Score> {

    private static final int MAX_SCORES = 10;
    private ArrayList<Score> scores;

    public Tableau() {
        scores = ParseurHighscores.charger();
    }

    public void ajouter(String nom, int score) {
        int i = 0;
        for(Score sc : scores) {
            if(sc.getScore() > score) {
                break;
            }
            i++;
        }
        scores.add(i, new Score(nom, score));

        if(scores.size() > MAX_SCORES) {
            scores.remove(scores.size() - 1);
        }

        SauverHighscores.sauvegarder(this);
    }

    public int getSize() {
        return scores.size();
    }

    @Override
    public Iterator<Score> iterator() {
        return scores.iterator();
    }
}
