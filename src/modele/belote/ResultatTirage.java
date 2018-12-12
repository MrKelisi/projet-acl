package modele.belote;

import modele.cartes.CarteAJouer;

public class ResultatTirage {
    private CarteAJouer carte1;
    private CarteAJouer carte2;
    private int resultat;

    /**
     * @return La première carte du tirage
     */
    public CarteAJouer getCarte1() {
        return carte1;
    }

    /**
     * Définie la première carte du tirage
     * @param carte1 Première carte
     */
    public void setCarte1(CarteAJouer carte1) {
        this.carte1 = carte1;
    }

    /**
     * @return La deuxième carte du tirage
     */
    public CarteAJouer getCarte2() {
        return carte2;
    }

    /**
     * Définie la deuxime carte du tirage
     * @param carte2 Deuxième carte
     */
    public void setCarte2(CarteAJouer carte2) {
        this.carte2 = carte2;
    }

    /**
     * @return Le résultat du tirage (comparaison des cartes)
     */
    public int getResultat() {
        return resultat;
    }

    /**
     * Définie le résultat du tirage
     * @param resultat Résultat
     */
    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
}
