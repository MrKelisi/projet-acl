package modele.joueurs;

import modele.cartes.Carte;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class JoueurActif extends Joueur {
    private static JoueurActif instance;

    private int tour;
    private int resultat;
    private int score;
    private Carte carte1, carte2;

    private JoueurActif(String nom) {
        super(nom);
        tour = 0;
        resultat = 0;
        score = 0;
    }

    public static void setPseudonyme(String pseudonyme) {
        instance = new JoueurActif(pseudonyme);
    }

    public static JoueurActif getInstance() {
        if(instance == null) {
            setPseudonyme("Joueur");
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

    public Carte getCarte1() {
        return carte1;
    }

    public Carte getCarte2() {
        return carte2;
    }

    public void setResultat(int res) {
        resultat = res;
        score += res;
    }

    public void tirer(ArrayList<Carte> cartes) {
        int index1 = ThreadLocalRandom.current().nextInt(0, cartes.size());
        int index2 = ThreadLocalRandom.current().nextInt(0, cartes.size());

        carte1 = cartes.get(index1);
        carte2 = cartes.get(index2);

        tour++;
    }

}
