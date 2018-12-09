package modele.joueurs;

import modele.cartes.CarteAJouer;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class JoueurActif extends Joueur {
    private static JoueurActif instance;

    private int tour;
    private int resultat;
    private int score;
    private CarteAJouer carte1, carte2;

    private JoueurActif(String nom) {
        super(nom);
        tour = 0;
        resultat = 0;
        score = 0;
    }

    /**
     * Change le joueur actif
     * @param pseudonyme Nom du nouveau joueur
     */
    public static void nouveau(String pseudonyme) {
        instance = new JoueurActif(pseudonyme);
    }

    /**
     * @return Joueur actif actuel
     */
    public static JoueurActif getInstance() {
        if(instance == null) {
            nouveau("Joueur");
        }
        return instance;
    }

    /**
     * @return Tour du joueur
     */
    public int tour() {
        return tour;
    }

    /**
     * @return Résultat du tour
     */
    public int resultat() {
        return resultat;
    }

    /**
     * @return Score du joueur
     */
    public int score() {
        return score;
    }

    /**
     * @return Première carte tirée par le joueur
     */
    public CarteAJouer getCarte1() {
        return carte1;
    }

    /**
     * @return Seconde carte tirée par le joueur
     */
    public CarteAJouer getCarte2() {
        return carte2;
    }

    /**
     * Change le résultat du tour du joueur
     * @param res Nouveau résultat
     */
    public void setResultat(int res) {
        resultat = res;
        score += res;
    }

    /**
     * Tire deux cartes parmi un tas de cartes
     * @param cartes Tas de cartes
     */
    public void tirer(ArrayList<CarteAJouer> cartes) {
        int index1 = ThreadLocalRandom.current().nextInt(0, cartes.size());
        int index2 = ThreadLocalRandom.current().nextInt(0, cartes.size());

        carte1 = cartes.get(index1);
        carte2 = cartes.get(index2);

        tour++;
    }

}
