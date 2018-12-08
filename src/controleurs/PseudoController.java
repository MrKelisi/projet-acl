package controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.joueurs.JoueurActif;

public class PseudoController extends DefaultController {

    @FXML
    private TextField pseudonyme;

    @FXML
    protected void afficherMenuPrincipal() {
        fenetre.setVue("menu");
    }

    @FXML
    protected void afficherPlateau() {
        JoueurActif.setPseudonyme(pseudonyme.getText());
        fenetre.setVue("plateau");
    }

}
