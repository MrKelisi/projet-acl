package vues;

import javafx.stage.Stage;
import jeu.Jeu;
import vues.controllers.PseudoController;

public class VuePseudo extends VueDefault {

    private PseudoController controller;

    public VuePseudo(Stage primaryStage, Jeu jeu) {
        super("fxml/pseudo.fxml", jeu);

        controller = loader.getController();
        controller.setPrimaryScene(primaryStage);
    }

    public void setMenu(VueMenu vue) {
        controller.setMenu(vue);
    }

    public void setPlateau(VuePlateau vue) {
        controller.setPlateau(vue);
    }

}
