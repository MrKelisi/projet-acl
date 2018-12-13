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

        JoueurActif.nouveau("Patrick", vue);

        vue.getAbandonnerBtn().setOnAction((event -> fenetre.setVue("menu")));
        vue.getTourSuivantBtn().setOnAction((event) -> JoueurActif.getInstance().tirer());
    }

    @Override
    public Vue getVue() {
        return vue;
    }

}
