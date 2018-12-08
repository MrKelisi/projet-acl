package vues;

import modele.jeu.JeuBelote;
import controleurs.PlateauController;

public class VuePlateau extends VueDefault {

    public VuePlateau(JeuBelote jeu, Fenetre fenetre) {
        super("fxml/plateau.fxml", jeu, fenetre);

    }

    @Override
    public void init() {
        ((PlateauController) controller).demarrer();
    }

}
