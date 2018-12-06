package vues;

import modele.jeu.JeuBelote;
import controleurs.HighscoresController;

public class VueHighscores extends VueDefault {

    public VueHighscores(JeuBelote jeu) {
        super("fxml/highscores.fxml", jeu);

    }

    @Override
    public void init() {
        ((HighscoresController) controller).chargerTableau();
    }

}
