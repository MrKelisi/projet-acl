package controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import modele.highscores.Record;
import modele.highscores.Tableau;

public class HighscoresController extends DefaultController {

    @FXML
    private TableView tableau;

    @FXML
    protected void afficherMenuPrincipal() {
        fenetre.setVue("menu");
    }

    @Override
    public void init() {
        super.init();

        tableau.getItems().clear();
        for(Record record : Tableau.getInstance()) {
            tableau.getItems().add(record);
        }
    }
}
