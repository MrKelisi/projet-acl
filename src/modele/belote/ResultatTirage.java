package modele.belote;

import modele.cartes.CarteAJouer;

public class ResultatTirage {
    private CarteAJouer carte1;
    private CarteAJouer carte2;
    private int resultat;

    public CarteAJouer getCarte1() {
        return carte1;
    }

    public void setCarte1(CarteAJouer carte1) {
        this.carte1 = carte1;
    }

    public CarteAJouer getCarte2() {
        return carte2;
    }

    public void setCarte2(CarteAJouer carte2) {
        this.carte2 = carte2;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
}
