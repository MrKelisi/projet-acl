import jeu.Jeu;
import vues.Fenetre;

public class Main {

    public static void main(String[] args) {

        Jeu jeu = new Jeu();
        jeu.demarrer();

        Fenetre fenetre = new Fenetre("Jeu de cartes", jeu);
        fenetre.afficher();

    }
}
