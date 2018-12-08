package modele.joueurs;

import java.util.HashMap;

public class Joueur {

    private static HashMap<String, Joueur> joueurs = new HashMap<>();

    private String nom;

    protected Joueur(String nom) {
        this.nom = nom;
    }

    public static Joueur get(String nom) {

        Joueur joueur = joueurs.get(nom);

        if(joueur == null) {
            joueur = new Joueur(nom);
            joueurs.put(nom, joueur);
        }

        return joueur;
    }

    public String nom() {
        return nom;
    }

}
