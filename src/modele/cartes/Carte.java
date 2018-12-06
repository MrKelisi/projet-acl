package modele.cartes;

public class Carte {
    private int valeur;
    private Figures figure;
    private Categories categorie;

    public Carte(int valeur, Figures figure, Categories categorie) {
        this.valeur = valeur;
        this.figure = figure;
        this.categorie = categorie;
    }

    public int valeur() {
        return valeur;
    }
    public Figures figure() {
        return figure;
    }
    public Categories categorie() {
        return categorie;
    }

    @Override
    public String toString() {
        return figure + " de " + categorie + " (" + valeur + ")";
    }
}
