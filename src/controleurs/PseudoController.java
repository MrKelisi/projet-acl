package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PseudoController extends DefaultController {

    @FXML
    private TextField pseudonyme;

    @FXML
    protected void afficherMenuPrincipal(ActionEvent event) {
        fenetre.setVue("menu");
    }

    @FXML
    protected void afficherPlateau(ActionEvent event) {
        jeu.setPseudonyme(pseudonyme.getText());
        fenetre.setVue("plateau");
    }

}
