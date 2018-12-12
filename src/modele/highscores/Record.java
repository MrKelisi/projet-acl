package modele.highscores;

import modele.Joueur;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {

    private final static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy à HH:mm:ss");

    private Joueur joueur;
    private int score;
    private Date date;

    /**
     * Crée un nouveau record à la date d'exécution
     * @param joueur Joueur
     * @param score Score du joueur dans la partie
     */
    public Record(Joueur joueur, int score) {
        this(joueur, score, new Date());
    }

    /**
     * Crée un record précédemment réalisé à la date donnée
     * @param joueur Joueur
     * @param score Score du joueur dans la partie
     * @param date Date du record
     */
    public Record(Joueur joueur, int score, Date date) {
        this.joueur = joueur;
        this.score = score;
        this.date = date;
    }

    /**
     * Retourne le joueur associé à ce record
     * @return joueur
     */
    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * Retourne le nom du joueur
     * @return Nom du joueur
     */
    public String getNom() {
        return joueur.getNom();
    }

    /**
     * Retourne le score
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Retourne la date du record
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Retourne la date formatée du record
     * @return date formatée
     */
    public String getFormattedDate() {
        return SDF.format(date);
    }

    public String toString() {
        return getNom() + ", " + getScore() + ", " + getDate();
    }

}
