package vues;

import modele.jeu.JeuBelote;
import controleurs.PlateauController;

public class VuePlateau extends VueDefault {

    public VuePlateau(JeuBelote jeu) {
        super("fxml/plateau.fxml", jeu);

    }

    @Override
    public void init() {
        ((PlateauController) controller).demarrer();
    }

}
