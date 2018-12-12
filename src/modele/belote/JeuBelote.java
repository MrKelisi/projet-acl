package modele.belote;

import modele.cartes.CarteAJouer;
import modele.cartes.EnseigneCarte;
import modele.cartes.FigureCarte;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class JeuBelote {

    public final static int MAX_TOURS = 5;
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

    /**
     * Tire 2 cartes et retourne le résultat du tirage
     * @return Résultat du tirage
     */
    public ResultatTirage tirer() {
        ResultatTirage resultat = new ResultatTirage();

        int index1 = ThreadLocalRandom.current().nextInt(0, cartes.size());
        int index2 = ThreadLocalRandom.current().nextInt(0, cartes.size());

        CarteAJouer carte1 = cartes.get(index1);
        CarteAJouer carte2 = cartes.get(index2);

        int res = carte1.valeur() + carte2.valeur();
        if(carte1.figure().equals(carte2.figure())) {
            res = -res;
            if(carte1.enseigne().ordinal() % 2 == carte2.enseigne().ordinal() % 2) {
                res *= 2;
            }
        }

        resultat.setCarte1(carte1);
        resultat.setCarte2(carte2);
        resultat.setResultat(res);

        return resultat;
    }
}
