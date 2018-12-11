package modele;

public class Joueur {
    private String nom;

    public Joueur(String nom) {
        this.nom = nom;
    }

    /**
     * @return Nom du joueur
     */
    public String getNom() {
        return nom;
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof Joueur)) {
            return false;
        }
        return nom.equals(((Joueur) o).nom);
    }
}
