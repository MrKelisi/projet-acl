package cartes;

public class Figure {
    private String nom;
    private int points;

    public Figure(String nom, int points) {
        if(nom == null) {
            throw new NullPointerException("Nom null");
        }

        this.nom = nom;
        this.points = points;
    }

    public String getNom() {
        return nom;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof Figure)) {
            return false;
        }

        Figure figure = (Figure) o;
        return points == figure.points && nom.equals(figure.nom);
    }

    @Override
    public String toString() {
        return "Figure{" +
                "nom='" + nom + '\'' +
                ", points=" + points +
                '}';
    }
}
