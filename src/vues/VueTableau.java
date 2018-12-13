package vues;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import modele.highscores.TableauRecords;

import java.util.Observable;

import static javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY;

public class VueTableau extends Vue {

    private Button menuPrincipal;

    public VueTableau() {

        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);

        Text titre = new Text("Tableau des records");
        titre.setTextAlignment(TextAlignment.CENTER);
        titre.setFont(Font.font(30));
        mainGrid.add(titre, 0, 0);

        TableView tableView = new TableView();
        tableView.setMaxHeight(280);
        tableView.setPrefWidth(500);
        tableView.setFixedCellSize(25);
        tableView.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        mainGrid.add(tableView, 0, 1);

        menuPrincipal = new Button("Menu principal");
        mainGrid.add(menuPrincipal, 0,2);

        scene = new Scene(mainGrid, WIDTH, HEIGHT);
    }

    public Button getMenuPrincipalBtn() {
        return menuPrincipal;
    }

    private void refresh(TableauRecords tableau) {

    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof TableauRecords) {
            refresh((TableauRecords) arg);
        }
    }
}
