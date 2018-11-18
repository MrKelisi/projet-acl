package cartes.figures;

import cartes.Carte;
import cartes.Categorie;

public class Dame extends Carte {

    public Dame(Categorie categorie) {
        super("D", categorie);
    }

    @Override
    public int getValeur() {
        return 3;
    }

}
