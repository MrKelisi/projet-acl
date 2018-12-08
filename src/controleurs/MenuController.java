package controleurs;

import javafx.fxml.FXML;

public class MenuController extends DefaultController {

    @FXML
    protected void afficherFormulairePseudonyme() {
        fenetre.setVue("pseudo");
    }

    @FXML
    protected void afficherTableauScores() {
        fenetre.setVue("highscores");
    }

    @FXML
    protected void quitter() {
        fenetre.fermer();
    }
}