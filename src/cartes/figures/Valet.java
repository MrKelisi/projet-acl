package cartes.figures;

import cartes.Carte;
import cartes.Categorie;

public class Valet extends Carte {

    public Valet(Categorie categorie) {
        super("V", categorie);
    }

    @Override
    public int getValeur() {
        return 2;
    }

}
