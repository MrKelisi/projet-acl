package controleurs;

import modele.highscores.Score;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class HighscoresController extends DefaultController {

    @FXML
    private TableView tableau;

    @FXML
    protected void menu(ActionEvent event) {
        vue.changerVue("menu");
    }

    public void chargerTableau() {
        tableau.getItems().clear();
        for(Score sc : jeu.tableau()) {
            tableau.getItems().add(sc);
        }
    }

}
