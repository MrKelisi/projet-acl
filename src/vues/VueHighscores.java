package vues;

import modele.jeu.JeuBelote;
import controleurs.HighscoresController;

public class VueHighscores extends VueDefault {

    public VueHighscores(JeuBelote jeu, Fenetre fenetre) {
        super("fxml/highscores.fxml", jeu, fenetre);

    }

    @Override
    public void init() {
        ((HighscoresController) controller).chargerTableau();
    }

}
