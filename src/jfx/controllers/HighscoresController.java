package jfx.controllers;

import highscores.Score;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import jeu.Jeu;
import jfx.VueMenu;

public class HighscoresController extends DefaultController {

    private VueMenu menu;
    private Jeu jeu;

    @FXML
    private TableView tableau;

    public void setMenu(VueMenu menu) {
        this.menu = menu;
        this.jeu = menu.getJeu();
    }

    @FXML
    protected void menu(ActionEvent event) {
        primaryStage.setScene(menu.getScene());
    }

    public void charger() {
        tableau.getItems().clear();
        for(Score sc : jeu.tableau()) {
            tableau.getItems().add(sc);
        }
    }

}
