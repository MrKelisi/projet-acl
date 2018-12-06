package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController extends DefaultController {

    @FXML
    protected void jouer(ActionEvent event) {
        vue.changerVue("pseudo");
    }

    @FXML
    protected void highscores(ActionEvent event) {
        vue.changerVue("highscores");
    }

    @FXML
    protected void quitter(ActionEvent event) {
        vue.changerVue("");
    }
}