package modele.jeu;

import modele.cartes.CarteAJouer;
import modele.cartes.EnseigneCarte;
import modele.cartes.FigureCarte;
import modele.highscores.TableauRecords;
import modele.joueurs.JoueurActif;

import java.util.ArrayList;

public class JeuBelote implements JeuCartes {

    private final static int MAX_TOURS = 5;
    private static ArrayList<CarteAJouer> cartes;

    /**
     * Création d'un jeu de belote (32 cartes)
     */
    public JeuBelote() {
        cartes = new ArrayList<>();

        int valeur;
        for(EnseigneCarte enseigne : EnseigneCarte.values()) {
            for(FigureCarte figure : FigureCarte.values()) {

                switch (figure) {
                    case DIX:   valeur = 10; break;
                    case VALET: valeur = 2;  break;
                    case DAME:  valeur = 3;  break;
                    case ROI:   valeur = 4;  break;
                    case AS:    valeur = 11; break;
                    default:    valeur = 0;
                }
                cartes.add(new CarteAJouer(valeur, figure, enseigne));
            }
        }
    }


    @Override
    public boolean tirer() {

        if(estTermine()) {
            return false;
        }

        JoueurActif.getInstance().tirer(cartes);
        CarteAJouer carte1 = JoueurActif.getInstance().getCarte1();
        CarteAJouer carte2 = JoueurActif.getInstance().getCarte2();

        int res = carte1.valeur() + carte2.valeur();
        if(carte1.figure().equals(carte2.figure())) {
            res = -res;
            if(carte1.categorie().ordinal() % 2 == carte2.categorie().ordinal() % 2) {
                res *= 2;
            }
        }

        JoueurActif.getInstance().setResultat(res);
        return true;
    }

    @Override
    public boolean estTermine() {
        return (JoueurActif.getInstance().tour() >= MAX_TOURS);
    }

    @Override
    public void sauvegarder() {
        TableauRecords.getInstance().ajouter(JoueurActif.getInstance());
    }
}
