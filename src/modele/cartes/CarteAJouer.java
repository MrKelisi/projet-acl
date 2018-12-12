package modele.cartes;

public class CarteAJouer {
    private int valeur;
    private FigureCarte figure;
    private EnseigneCarte enseigne;

    /**
     * Crée une carte à jouer avec une valeur, une figure et une enseigne
     * @param valeur La valeur de la carte
     * @param figure La figure de la carte
     * @param enseigne L'enseigne de la carte
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
     * Retourne la figure de la carte
     * @return figure
     */
    public FigureCarte figure() {
        return figure;
    }

    /**
     * Retourne l'enseigne de la carte
     * @return enseigne
     */
    public EnseigneCarte enseigne() {
        return enseigne;
    }

    @Override
    public String toString() {
        return figure + " de " + enseigne + " (" + valeur + ")";
    }
}
