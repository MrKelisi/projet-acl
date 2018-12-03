package highscores;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Score {

    private final static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy à HH:mm:ss");

    private String nom;
    private int score;
    private Date date;

    public Score(String nom, int score) {
        this(nom, score, new Date());
    }

    public Score(String nom, int score, Date date) {
        this.nom = nom;
        this.score = score;
        this.date = date;
    }

    public String getNom() {
        return nom;
    }
    public int getScore() {
        return score;
    }
    public Date getDate() {
        return date;
    }
    public String getFormattedDate() {
        return SDF.format(date);
    }

    public String toString() {
        return getNom() + ", " + getScore() + ", " + getDate();
    }

}
