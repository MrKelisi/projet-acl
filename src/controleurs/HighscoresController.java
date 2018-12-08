package controleurs;

import modele.highscores.Score;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import modele.highscores.Tableau;

public class HighscoresController extends DefaultController {

    @FXML
    private TableView tableau;

    @FXML
    protected void afficherMenuPrincipal(ActionEvent event) {
        fenetre.setVue("menu");
    }

    @Override
    public void init() {
        super.init();

        tableau.getItems().clear();
        for(Score sc : Tableau.getInstance()) {
            tableau.getItems().add(sc);
        }
    }
}
