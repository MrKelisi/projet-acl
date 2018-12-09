package controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import modele.highscores.Record;
import modele.highscores.TableauRecords;

public class HighscoresController extends BaseController {

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
        for(Record record : TableauRecords.getInstance()) {
            tableau.getItems().add(record);
        }
    }
}
