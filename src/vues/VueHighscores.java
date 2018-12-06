package vues;

import javafx.stage.Stage;
import jeu.Jeu;
import vues.controllers.HighscoresController;

public class VueHighscores extends VueDefault {

    private HighscoresController controller;

    public VueHighscores(Stage primaryStage, Jeu jeu) {
        super("fxml/highscores.fxml", jeu);

        controller = loader.getController();
        controller.setPrimaryScene(primaryStage);
    }

    public void setMenu(VueMenu vue) {
        controller.setMenu(vue);
    }

    public void chargerTableau() {
        controller.charger();
    }

}
