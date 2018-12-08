package modele.cartes;

public class Carte {
    private int valeur;
    private Figure figure;
    private Categorie categorie;

    public Carte(int valeur, Figure figure, Categorie categorie) {
        this.valeur = valeur;
        this.figure = figure;
        this.categorie = categorie;
    }

    public int valeur() {
        return valeur;
    }
    public Figure figure() {
        return figure;
    }
    public Categorie categorie() {
        return categorie;
    }

    @Override
    public String toString() {
        return figure + " de " + categorie + " (" + valeur + ")";
    }
}
