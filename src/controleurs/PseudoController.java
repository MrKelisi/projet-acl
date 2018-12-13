package controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.belote.JoueurActif;

public class PseudoController extends BaseController {

    @FXML
    private TextField pseudonyme;

    @FXML
    protected void afficherMenuPrincipal() {
        fenetre.setVue("menu");
    }

    @FXML
    protected void afficherPlateau() {
        //JoueurActif.nouveau(pseudonyme.getText());
        fenetre.setVue("plateau");
    }

}
