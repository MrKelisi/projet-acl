package vues;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import modele.highscores.Record;
import modele.highscores.TableauRecords;

import java.util.Observable;

import static javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY;

public class VueTableau extends Vue {
    private ObservableList<Record> records;
    private Button menuPrincipal;

    public VueTableau() {
        records = FXCollections.observableArrayList();

        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);

        Text titre = new Text("Tableau des records");
        titre.setTextAlignment(TextAlignment.CENTER);
        titre.setFont(Font.font(30));
        mainGrid.add(titre, 0, 0);

        TableView<Record> tableView = new TableView<>();
        tableView.setMaxHeight(280);
        tableView.setPrefWidth(500);
        tableView.setFixedCellSize(25);
        tableView.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);

        TableColumn<Record, String> nameColumn = new TableColumn<>("Nom");
        TableColumn<Record, Integer> scoreColumn = new TableColumn<>("Score");
        TableColumn<Record, String> dateColumn = new TableColumn<>("Date");

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("formattedDate"));

        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(scoreColumn);
        tableView.getColumns().add(dateColumn);

        tableView.setItems(records);

        mainGrid.add(tableView, 0, 1);

        menuPrincipal = new Button("Menu principal");
        mainGrid.add(menuPrincipal, 0,2);

        scene = new Scene(mainGrid, WIDTH, HEIGHT);

        TableauRecords.getInstance().addObserver(this);
        refresh(TableauRecords.getInstance());
    }

    public Button getMenuPrincipalBtn() {
        return menuPrincipal;
    }

    private void refresh(TableauRecords tableau) {
        records.remove(0, records.size());

        for(Record record : tableau) {
            records.add(record);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof TableauRecords) {
            refresh((TableauRecords) o);
        }
    }
}
