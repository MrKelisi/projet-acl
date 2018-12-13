package controleurs;

import vues.Fenetre;
import vues.Vue;
import vues.VueMenu;

public class ControleurMenu extends Controleur {

    private VueMenu vue;

    public ControleurMenu(Fenetre fenetre) {
        super(fenetre);

        vue = new VueMenu();

        vue.getJouerBtn().setOnAction((event -> fenetre.setVue("jeu")));
        vue.getTableauDesRecordsBtn().setOnAction((event -> fenetre.setVue("tableau")));
        vue.getQuitterBtn().setOnAction((event) -> fenetre.fermer());
    }

    @Override
    public Vue getVue() {
        return vue;
    }
}
