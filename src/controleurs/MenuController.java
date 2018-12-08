package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController extends DefaultController {

    @FXML
    protected void jouer(ActionEvent event) {
        fenetre.setVue("pseudo");
    }

    @FXML
    protected void highscores(ActionEvent event) {
        fenetre.setVue("highscores");
    }

    @FXML
    protected void quitter(ActionEvent event) {
        fenetre.fermer();
    }
}