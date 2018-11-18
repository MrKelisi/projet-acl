package cartes.figures;

import cartes.Carte;
import cartes.Categorie;

public class Dix extends Carte {

    public Dix(Categorie categorie) {
        super("10", categorie);
    }

    @Override
    public int getValeur() {
        return 10;
    }

}
