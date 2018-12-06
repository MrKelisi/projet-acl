package controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PseudoController extends DefaultController {

    @FXML
    private TextField pseudonyme;

    @FXML
    protected void menu(ActionEvent event) {
        vue.changerVue("menu");
    }

    @FXML
    protected void plateau(ActionEvent event) {
        jeu.setPseudonyme(pseudonyme.getText());
        vue.changerVue("plateau");
    }

}
