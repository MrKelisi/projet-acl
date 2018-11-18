package cartes.figures;

import cartes.Carte;
import cartes.Categorie;

public class Roi extends Carte {

    public Roi(Categorie categorie) {
        super("R", categorie);
    }

    @Override
    public int getValeur() {
        return 4;
    }

}
