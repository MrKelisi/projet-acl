package cartes;

public class Categorie {
    private String couleur;
    private String nom;

    public Categorie(String couleur, String nom) {
        this.couleur = couleur;
        this.nom = nom;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof Categorie)) {
            return false;
        }

        Categorie categorie = (Categorie) o;
        return couleur.equals(categorie.couleur) && nom.equals(categorie.nom);
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "couleur='" + couleur + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
