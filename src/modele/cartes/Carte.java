package modele.cartes;

public class Carte {
    private int valeur;
    private Figure figure;
    private Categorie categorie;

    /**
     * Crée une carte à jouer avec une valeur, une figure et une catégorie
     * @param valeur La valeur de la carte
     * @param figure La figure de la carte
     * @param categorie La catégorie de la carte
     */
    public Carte(int valeur, Figure figure, Categorie categorie) {
        this.valeur = valeur;
        this.figure = figure;
        this.categorie = categorie;
    }

    /**
     * Retourne la valeur de la carte dans le jeu
     * @return valeur
     */
    public int valeur() {
        return valeur;
    }

    /**
     * Retourne le type de figure
     * @return figure
     */
    public Figure figure() {
        return figure;
    }

    /**
     * Retourne la catégorie
     * @return categorie
     */
    public Categorie categorie() {
        return categorie;
    }

    @Override
    public String toString() {
        return figure + " de " + categorie + " (" + valeur + ")";
    }
}
