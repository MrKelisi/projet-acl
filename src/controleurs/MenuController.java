package controleurs;

import javafx.fxml.FXML;

public class MenuController extends BaseController {

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