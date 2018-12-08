package controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.joueurs.JoueurActif;

public class PseudoController extends DefaultController {

    @FXML
    private TextField pseudonyme;

    @FXML
    protected void menu() {
        fenetre.setVue("menu");
    }

    @FXML
    protected void plateau() {
        JoueurActif.set(pseudonyme.getText());
        fenetre.setVue("plateau");
    }

}
