package cartes.figures;

import cartes.Carte;
import cartes.Categorie;

public class As extends Carte {

    public As(Categorie categorie) {
        super("A", categorie);
    }

    @Override
    public int getValeur() {
        return 11;
    }

}
