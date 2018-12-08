package modele.highscores;

import modele.joueurs.Joueur;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Score {

    private final static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy à HH:mm:ss");

    private Joueur joueur;
    private int score;
    private Date date;

    /**
     * Crée un nouveau score à la date d'exécution
     * @param joueur Joueur
     * @param score Score du joueur dans la partie
     */
    public Score(Joueur joueur, int score) {
        this(joueur, score, new Date());
    }

    /**
     * Crée un score précédemment réalisé à la Date date
     * @param joueur Joueur
     * @param score Score du joueur dans la partie
     * @param date Date du score
     */
    public Score(Joueur joueur, int score, Date date) {
        this.joueur = joueur;
        this.score = score;
        this.date = date;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * Retourne le nom du joueur
     * @return nom
     */
    public String getNom() {
        return joueur.nom();
    }

    /**
     * Retourne le score
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Retourne la date du score
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Retourne la date formatée du score
     * @return date formatée
     */
    public String getFormattedDate() {
        return SDF.format(date);
    }

    public String toString() {
        return getNom() + ", " + getScore() + ", " + getDate();
    }

}
