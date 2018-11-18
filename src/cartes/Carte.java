package cartes;

import java.awt.*;

public class Carte {

    private String libelle;
    private Categorie categorie;

    public Carte(String libelle, Categorie categorie) {
        this.libelle = libelle;
        this.categorie = categorie;
    }

    public int getValeur() {
        return 0;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public Color getCouleur() {
        return (categorie.ordinal() % 2 == 0) ? Color.BLACK : Color.RED;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "libelle='" + getLibelle() +
                ", valeur=" + getValeur() +
                ", categorie=" + getCategorie() +
                ", couleur=" + getCouleur() +
                '}';
    }
}
