package controleurs;

import javafx.fxml.FXML;

public class MenuController extends DefaultController {

    @FXML
    protected void jouer() {
        fenetre.setVue("pseudo");
    }

    @FXML
    protected void highscores() {
        fenetre.setVue("highscores");
    }

    @FXML
    protected void quitter() {
        fenetre.fermer();
    }
}