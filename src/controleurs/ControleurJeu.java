package controleurs;

import modele.belote.JoueurActif;
import vues.Fenetre;
import vues.Vue;
import vues.VueJeu;

public class ControleurJeu extends Controleur {

    private VueJeu vue;

    public ControleurJeu(Fenetre fenetre) {
        super(fenetre);

        vue = new VueJeu();

        vue.getTourSuivantBtn().setOnAction((event) -> JoueurActif.getInstance().tirer());
        vue.getAbandonnerBtn().setOnAction((event -> fenetre.setVue("menu")));
    }

    @Override
    public Vue getVue() {
        return vue;
    }

}
