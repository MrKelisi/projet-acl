package controleurs;

import modele.highscores.TableauRecords;
import vues.Fenetre;
import vues.Vue;
import vues.VueTableau;

public class ControleurTableau extends Controleur {

    private VueTableau vue;

    public ControleurTableau(Fenetre fenetre) {
        super(fenetre);

        vue = new VueTableau();

        TableauRecords.getInstance().addObserver(vue);

        vue.getMenuPrincipalBtn().setOnAction((event) -> fenetre.setVue("menu"));
    }

    @Override
    public Vue getVue() {
        return vue;
    }

}
