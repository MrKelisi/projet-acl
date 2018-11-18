package highscores;

import java.util.Date;

public class Score {

    private String nom;
    private int score;
    private Date date;

    public Score(String nom, int score) {
        this.nom = nom;
        this.score = score;
        this.date = new Date();
    }

    public String getNom() {
        return nom;
    }
    public int getScore() {
        return score;
    }
    public String getDate() {
        return date.toString();
    }

    public String toString() {
        return getNom() + ", " + getScore() + ", " + getDate();
    }

}
