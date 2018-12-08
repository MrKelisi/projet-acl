package modele.jeu;

import modele.cartes.Carte;
import modele.cartes.Categorie;
import modele.cartes.Figure;
import modele.highscores.Tableau;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class JeuBelote implements Jeu {

    private final static int MAX_TOURS = 5;

    private int tour;
    private int resultat;
    private int score;
    private Carte carte1, carte2;

    private ArrayList<Carte> cartes;
    private String pseudonyme;

    /**
     * Création d'un jeu de belote (32 cartes)
     */
    public JeuBelote() {
        cartes = new ArrayList<>();
        pseudonyme = "Joueur";

        int valeur;
        for(Categorie categorie : Categorie.values()) {
            for(Figure figure : Figure.values()) {

                switch (figure) {
                    case DIX:   valeur = 10; break;
                    case VALET: valeur = 2;  break;
                    case DAME:  valeur = 3;  break;
                    case ROI:   valeur = 4;  break;
                    case AS:    valeur = 11; break;
                    default:    valeur = 0;
                }
                cartes.add(new Carte(valeur, figure, categorie));
            }
        }
    }

    /**
     * Numéro du tour actuel de la partie
     * @return tour
     */
    public int tour() {
        return tour;
    }

    /**
     * Resultat actuel de la partie
     * @return resultat
     */
    public int resultat() {
        return resultat;
    }

    /**
     * Score actuel de la partie
     * @return score
     */
    public int score() {
        return score;
    }

    /**
     * Valeur actuel de la carte i
     * @param i Numéro de la carte désirée
     * @return La carte demandée
     */
    public Carte carte(int i) {
        return (i%2 == 0 ? carte1 : carte2);
    }

    /**
     * Pseudonyme du joueur de la partie
     * @return pseudonyme
     */
    public String pseudonyme() {
        return pseudonyme;
    }

    /**
     * Défini le pseudonyme du joueur pour la partie
     * @param pseudonyme
     */
    public void setPseudonyme(String pseudonyme) {
        this.pseudonyme = pseudonyme;
    }

    @Override
    public void demarrer() {
        resultat = score = tour = 0;
    }

    @Override
    public boolean tirer() {

        if(estTermine()) {
            return false;
        }

        int index1 = ThreadLocalRandom.current().nextInt(0, cartes.size());
        int index2 = ThreadLocalRandom.current().nextInt(0, cartes.size());

        carte1 = cartes.get(index1);
        carte2 = cartes.get(index2);

        int res = carte1.valeur() + carte2.valeur();
        if(carte1.figure().equals(carte2.figure())) {
            res = -res;
            if(carte1.categorie().ordinal() % 2 == carte2.categorie().ordinal() % 2) {
                res *= 2;
            }
        }

        tour ++;
        resultat = res;
        score   += res;

        return true;
    }

    @Override
    public boolean estTermine() {
        return (tour >= MAX_TOURS);
    }

    @Override
    public void sauvegarder() {
        Tableau.getInstance().ajouter(pseudonyme, score);
    }
}
