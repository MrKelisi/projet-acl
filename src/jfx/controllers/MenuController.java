package jfx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import jfx.VueHighscores;
import jfx.VuePseudo;

public class MenuController extends DefaultController {

    private VuePseudo pseudo;
    private VueHighscores highscores;

    public void setPseudo(VuePseudo pseudo) {
        this.pseudo = pseudo;
    }
    public void setHighscores(VueHighscores highscores) {
        this.highscores = highscores;
    }

    @FXML
    protected void jouer(ActionEvent event) {
        primaryStage.setScene(pseudo.getScene());
    }

    @FXML
    protected void highscores(ActionEvent event) {
        highscores.chargerTableau();
        primaryStage.setScene(highscores.getScene());
    }

    @FXML
    protected void quitter(ActionEvent event) {
        primaryStage.close();
    }
}
