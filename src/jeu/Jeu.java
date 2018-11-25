package jeu;

import cartes.Carte;
import cartes.PaquetCartes;
import cartes.PaquetCartesFrancais;
import highscores.Tableau;

import java.util.Random;

public class Jeu {

    public static final int MAX_TOURS = 5;

    private Random random = new Random();
    private Tableau tableau;
    private PaquetCartes paquet;
    private int tour;
    private int score;
    private int resultat;
    private Carte c1, c2;

    public Jeu() {
        tableau = new Tableau();
        paquet = new PaquetCartesFrancais();
        init(); //TODO: utile ? Sûrement rappelé par demarrer()
    }

    private void init() {
        paquet.generer();
        tour = score = resultat = 0;
        c1 = c2 = null;
    }

    public int demarrer() {
        init();
        return tourSuivant();
    }

    public int tourSuivant() {
        if(estTermine()) {
            throw new IndexOutOfBoundsException("Fin de la partie");
        }

        c1 = paquet.tirerCarte();
        c2 = paquet.tirerCarte();

        ++tour;
        resultat = comparer(c1, c2);
        score += resultat;

        return resultat;
    }

    private int comparer(Carte c1, Carte c2) {
        int res = c1.getFigure().getPoints() + c2.getFigure().getPoints() ;

        if(c1.getFigure().getNom().equals(c2.getFigure().getNom())) {
            res = -res;
            if(c1.getCategorie().getCouleur().equals(c2.getCategorie().getCouleur())) {
                res *= 2;
            }
        }

        return res;
    }

    public boolean estTermine() {
        return tour >= MAX_TOURS;
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
