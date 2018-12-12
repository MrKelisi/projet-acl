package vues;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class VuePlateau {

    private Stage primaryStage;
    private Scene scene;

    private ImageView carte1;
    private ImageView carte2;
    private Text resultat;

    private Button tourSuivant;

    public VuePlateau(Stage stage) {

        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setHgap(15);

        GridPane topGrid = new GridPane();
        topGrid.setAlignment(Pos.CENTER);
        topGrid.setHgap(15);
        mainGrid.add(topGrid, 0, 0);

        Image cartes = new Image("/vues/resources/cartes.png");

        carte1 = new ImageView();
        carte1.setImage(cartes);
        carte1.setViewport(new Rectangle2D(0,0,129,185));
        topGrid.add(carte1, 0, 0);

        carte2 = new ImageView();
        carte2.setImage(cartes);
        carte2.setViewport(new Rectangle2D(0,0,129,185));
        topGrid.add(carte2, 2, 0);

        resultat = new Text("0");
        resultat.setFont(Font.font(24));
        topGrid.add(resultat, 1, 0);

        tourSuivant = new Button("Tour suivant");
        mainGrid.add(tourSuivant, 0, 1);


        primaryStage = stage;
        scene = new Scene(mainGrid, 600, 450);
    }

    public Button getTourSuivantBtn() {
        return tourSuivant;
    }

    public void show() {
        primaryStage.setScene(scene);
    }

}
