package jeu;

import cartes.Carte;
import cartes.Categorie;
import cartes.figures.*;
import highscores.Tableau;

import java.util.ArrayList;
import java.util.Random;

public class Jeu {

    private Random random = new Random();
    private Tableau tableau;
    private ArrayList<Carte> paquet;
    private int tour;
    private int score;
    private int resultat;
    private Carte c1, c2;

    public Jeu() {
        tableau = new Tableau();
        init();
    }

    private void init() {
        paquet = new ArrayList<>();
        tour = score = resultat = 0;
        c1 = c2 = null;

        for(Categorie categorie : Categorie.values()) {
            for(int i = 7; i < 10; i++) {
                paquet.add(new Carte(Integer.toString(i), categorie));
            }
            paquet.add(new Dix(categorie));
            paquet.add(new Valet(categorie));
            paquet.add(new Dame(categorie));
            paquet.add(new Roi(categorie));
            paquet.add(new As(categorie));
        }
    }

    public int demarrer() {
        init();
        return tourSuivant();
    }

    public int tourSuivant() {
        ++tour;

        if(estTermine())
            throw new IndexOutOfBoundsException("Fin de la partie");

        c1 = paquet.remove(random.nextInt(paquet.size()));
        c2 = paquet.remove(random.nextInt(paquet.size()));

        resultat = comparer(c1, c2);
        score += resultat;

        return resultat;
    }

    private int comparer(Carte c1, Carte c2) {
        int res = c1.getValeur() + c2.getValeur();

        if(c1.getLibelle().equals(c2.getLibelle())) {
            res = -res;
            if(c1.getCouleur().equals(c2.getCouleur())) {
                res *= 2;
            }
        }

        return res;
    }

    public boolean estTermine() {
        return tour > 5;
    }

    public int tour() {
        return tour;
    }
    public int score() {
        return score;
    }
    public int resultat() {
        return resultat;
    }
    public Carte carte(int i) {
        return (i%2 == 0) ? c1 : c2;
    }
    public Tableau tableau() {
        return tableau;
    }

}
