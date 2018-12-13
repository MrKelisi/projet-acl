package vues;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Observable;

public class VuePseudo extends Vue {

    private TextField champ;

    private Button demarrerPartie;
    private Button abandonner;

    public VuePseudo() {

        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);

        Text titre = new Text("Choisissez un pseudonyme :");
        titre.setTextAlignment(TextAlignment.CENTER);
        titre.setFont(Font.font(30));
        mainGrid.add(titre, 0, 0, 2, 1);

        champ = new TextField();
        champ.setText("Joueur");
        mainGrid.add(champ, 0, 1, 2, 1);

        demarrerPartie = new Button("Démarrer la partie");
        mainGrid.add(demarrerPartie, 0, 2);

        abandonner = new Button("Abandonner");
        mainGrid.add(abandonner, 1, 2);

        scene = new Scene(mainGrid, WIDTH, HEIGHT);
    }

    public Button getDemarrerPartieBtn() {
        return demarrerPartie;
    }

    public Button getAbandonnerBtn() {
        return abandonner;
    }

    public String getNomJoueur() {
        return champ.getText();
    }

    @Override
    public void update(Observable o, Object arg) {}
}
