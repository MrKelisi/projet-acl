package vues;

import modele.jeu.JeuBelote;

public class VueMenu extends VueDefault {

    public VueMenu(JeuBelote jeu, Fenetre fenetre) {
        super("fxml/menu.fxml", jeu, fenetre);

    }

}
