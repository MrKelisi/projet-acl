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

    public static void nouveau(String pseudonyme) {
        instance = new JoueurActif(pseudonyme);
    }

    public static JoueurActif getInstance() {
        if(instance == null) {
            nouveau("Joueur");
        }
        return instance;
    }

    public int tour() {
        return tour;
    }

    public int resultat() {
        return resultat;
    }

    public int score() {
        return score;
    }

    public CarteAJouer getCarte1() {
        return carte1;
    }

    public CarteAJouer getCarte2() {
        return carte2;
    }

    public void setResultat(int res) {
        resultat = res;
        score += res;
    }

    public void tirer(ArrayList<CarteAJouer> cartes) {
        int index1 = ThreadLocalRandom.current().nextInt(0, cartes.size());
        int index2 = ThreadLocalRandom.current().nextInt(0, cartes.size());

        carte1 = cartes.get(index1);
        carte2 = cartes.get(index2);

        tour++;
    }

}
