package modele.jeu;

import modele.cartes.Carte;
import modele.cartes.Categorie;
import modele.cartes.Figure;
import modele.highscores.Tableau;
import modele.joueurs.Joueur;
import modele.joueurs.JoueurActif;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class JeuBelote implements Jeu {

    private final static int MAX_TOURS = 5;
    private static ArrayList<Carte> cartes;

    /**
     * Création d'un jeu de belote (32 cartes)
     */
    public JeuBelote() {
        cartes = new ArrayList<>();

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


    @Override
    public boolean tirer() {

        if(estTermine()) {
            return false;
        }

        JoueurActif.tirer(cartes);
        Carte carte1 = JoueurActif.carte(1);
        Carte carte2 = JoueurActif.carte(2);

        int res = carte1.valeur() + carte2.valeur();
        if(carte1.figure().equals(carte2.figure())) {
            res = -res;
            if(carte1.categorie().ordinal() % 2 == carte2.categorie().ordinal() % 2) {
                res *= 2;
            }
        }

        JoueurActif.setResultat(res);
        return true;
    }

    @Override
    public boolean estTermine() {
        return (JoueurActif.tour() >= MAX_TOURS);
    }

    @Override
    public void sauvegarder() {
        Tableau.getInstance().ajouter(JoueurActif.get(), JoueurActif.score());
    }
}
