package cartes;

public class Carte {
    private Categorie categorie;
    private Figure figure;

    public Carte(Figure figure, Categorie categorie) {
        this.figure = figure;
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public Figure getFigure() {
        return figure;
    }

    @Override
    public String toString() {
        return figure + " " + categorie;
    }
}
