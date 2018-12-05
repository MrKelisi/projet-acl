package jfx;

import javafx.stage.Stage;
import jeu.Jeu;
import jfx.controllers.PlateauController;

public class VuePlateau extends VueDefault {

    private PlateauController controller;

    public VuePlateau(Stage primaryStage, Jeu jeu) {
        super("fxml/plateau.fxml", jeu);

        controller = loader.getController();
        controller.setPrimaryScene(primaryStage);
    }

    public void setMenu(VueMenu vue) {
        controller.setMenu(vue);
    }

    public void demarrerJeu() {
        controller.init();
    }
    public void setPseudonyme(String pseudonyme) {
        controller.setPseudonyme(pseudonyme);
    }

}
