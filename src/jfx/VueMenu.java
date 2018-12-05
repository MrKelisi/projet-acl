package jfx;

import javafx.stage.Stage;
import jeu.Jeu;
import jfx.controllers.MenuController;

public class VueMenu extends VueDefault {

    private MenuController controller;

    public VueMenu(Stage primaryStage, Jeu jeu) {
        super("fxml/menu.fxml", jeu);

        controller = loader.getController();
        controller.setPrimaryScene(primaryStage);
    }

    public void setPseudo(VuePseudo vue) {
        controller.setPseudo(vue);
    }

    public void setHighscores(VueHighscores vue) {
        controller.setHighscores(vue);
    }

}
