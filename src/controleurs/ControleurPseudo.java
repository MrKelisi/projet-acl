package controleurs;

import modele.belote.JoueurActif;
import vues.Fenetre;
import vues.Vue;
import vues.VuePseudo;

public class ControleurPseudo extends Controleur {

    private VuePseudo vue;

    public ControleurPseudo(Fenetre fenetre) {
        super(fenetre);

        vue = new VuePseudo();

        vue.getDemarrerPartieBtn().setOnAction((event -> {
            JoueurActif.nouveau(vue.getNomJoueur());
            JoueurActif.getInstance().addObserver(fenetre.getVue("jeu"));
            JoueurActif.getInstance().tirer();
            fenetre.setVue("jeu");
        }));
        vue.getAbandonnerBtn().setOnAction((event -> fenetre.setVue("menu")));
    }

    @Override
    public Vue getVue() {
        return vue;
    }
}
