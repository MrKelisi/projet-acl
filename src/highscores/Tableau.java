package highscores;

import files.ParseurHighscores;

import java.util.ArrayList;

public class Tableau {

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

        if(scores.size() > MAX_SCORES)
            scores.remove(scores.size());
    }

    public int getSize() {
        return scores.size();
    }

    public String getLigne(int i) {
        return scores.get(i % scores.size()).toString();
    }

}
