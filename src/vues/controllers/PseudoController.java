package vues.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import vues.VueMenu;
import vues.VuePlateau;

public class PseudoController extends DefaultController {

    private VueMenu menu;
    private VuePlateau plateau;

    @FXML
    private TextField pseudonyme;

    @FXML
    protected void menu(ActionEvent event) {
        primaryStage.setScene(menu.getScene());
    }

    @FXML
    protected void plateau(ActionEvent event) {
        plateau.demarrerJeu();
        plateau.setPseudonyme(pseudonyme.getText());
        primaryStage.setScene(plateau.getScene());
    }

    public void setMenu(VueMenu menu) {
        this.menu = menu;
    }
    public void setPlateau(VuePlateau plateau) {
        this.plateau = plateau;
    }

}
