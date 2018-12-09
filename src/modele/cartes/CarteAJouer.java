package modele.cartes;

public class CarteAJouer {
    private int valeur;
    private FigureCarte figure;
    private EnseigneCarte enseigne;

    /**
     * Crée une carte à jouer avec une valeur, une figure et une catégorie
     * @param valeur La valeur de la carte
     * @param figure La figure de la carte
     * @param enseigne La catégorie de la carte
     */
    public CarteAJouer(int valeur, FigureCarte figure, EnseigneCarte enseigne) {
        this.valeur = valeur;
        this.figure = figure;
        this.enseigne = enseigne;
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
    public FigureCarte figure() {
        return figure;
    }

    /**
     * Retourne la catégorie
     * @return enseigne
     */
    public EnseigneCarte categorie() {
        return enseigne;
    }

    @Override
    public String toString() {
        return figure + " de " + enseigne + " (" + valeur + ")";
    }
}
