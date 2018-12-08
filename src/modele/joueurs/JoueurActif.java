package modele.joueurs;

import modele.cartes.Carte;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class JoueurActif extends Joueur {

    private static Joueur instance;

    private static int tour;
    private static int resultat;
    private static int score;
    private static Carte carte1, carte2;

    private JoueurActif() {
        super("Joueur");
    }

    public static Joueur get() {
        if(instance == null) {
            set("Joueur");
        }
        return instance;
    }

    public static void set(String nom) {
        instance = get(nom);
        tour = resultat = score = 0;
    }

    public static int tour() {
        return tour;
    }
    public static int resultat() {
        return resultat;
    }
    public static int score() {
        return score;
    }
    public static Carte carte(int i) {
        return (i%2 == 1 ? carte1 : carte2);
    }

    public static void setResultat(int res) {
        resultat = res;
        score += res;
    }

    public static void tirer(ArrayList<Carte> cartes) {
        int index1 = ThreadLocalRandom.current().nextInt(0, cartes.size());
        int index2 = ThreadLocalRandom.current().nextInt(0, cartes.size());

        carte1 = cartes.get(index1);
        carte2 = cartes.get(index2);

        tour++;
    }

}
