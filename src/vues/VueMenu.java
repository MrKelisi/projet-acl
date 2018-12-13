package vues;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Observable;

public class VueMenu extends Vue {

    private Button jouer;
    private Button tableauDesRecords;
    private Button quitter;

    public VueMenu() {

        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);

        Text titre = new Text("Projet d'ACL");
        titre.setTextAlignment(TextAlignment.CENTER);
        titre.setFont(Font.font(30));
        mainGrid.add(titre, 0, 0, 3, 1);

        jouer = new Button("Jouer");
        mainGrid.add(jouer, 0, 1);

        tableauDesRecords = new Button("Tableau des records");
        mainGrid.add(tableauDesRecords, 1, 1);

        quitter = new Button("Quitter");
        mainGrid.add(quitter, 2, 1);

        scene = new Scene(mainGrid, WIDTH, HEIGHT);
    }

    public Button getJouerBtn() {
        return jouer;
    }

    public Button getTableauDesRecordsBtn() {
        return tableauDesRecords;
    }

    public Button getQuitterBtn() {
        return quitter;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
