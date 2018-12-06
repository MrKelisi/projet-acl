package vues.controllers;

import files.ResourcesLoader;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.util.Duration;
import jeu.Jeu;
import vues.VueMenu;
import javafx.scene.image.ImageView;

public class PlateauController extends DefaultController {

    private VueMenu menu;
    private Jeu jeu;
    private Timeline timeline;
    private String pseudonyme = "Joueur";

    @FXML
    private ImageView carte1;
    @FXML
    private ImageView carte2;
    @FXML
    private Text resultat;
    @FXML
    private Text score;
    @FXML
    private Button toursuivant;
    @FXML
    private Button abandonner;


    public void setMenu(VueMenu menu) {
        this.menu = menu;
        this.jeu = menu.getJeu();
    }

    public void setPseudonyme(String pseudonyme) {
        this.pseudonyme = pseudonyme;
    }

    @FXML
    protected void menu(ActionEvent event) {
        if(jeu.estTermine()) {
            jeu.tableau().ajouter(pseudonyme, jeu.score());
        }
        primaryStage.setScene(menu.getScene());
    }

    @FXML
    protected void prochainTour(ActionEvent event) {
        jeu.tourSuivant();
        timeline.play();
        refreshScene();
    }

    private void refreshScene() {
        carte1.setViewport(ResourcesLoader.getCarteCoords(jeu.carte(1)));
        carte2.setViewport(ResourcesLoader.getCarteCoords(jeu.carte(2)));

        resultat.setText((jeu.resultat() > 0 ? "+" : "") + jeu.resultat());
        score.setText("Votre score : " + jeu.score());

        toursuivant.setText("Tour suivant (" + jeu.tour() + ")");

        if(jeu.estTermine()) {
            toursuivant.setDisable(true);
            abandonner.setText("Menu principal");
        }
    }

    public void init() {
        jeu.demarrer();
        refreshScene();

        timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(carte1.scaleXProperty(), 1)),
                new KeyFrame(Duration.ZERO, new KeyValue(carte1.scaleYProperty(), 1)),
                new KeyFrame(Duration.ZERO, new KeyValue(carte2.scaleXProperty(), 1)),
                new KeyFrame(Duration.ZERO, new KeyValue(carte2.scaleYProperty(), 1)),
                new KeyFrame(new Duration(120), new KeyValue(carte1.scaleXProperty(), 0)),
                new KeyFrame(new Duration(120), new KeyValue(carte1.scaleYProperty(), 1.05)),
                new KeyFrame(new Duration(120), new KeyValue(carte2.scaleXProperty(), 0)),
                new KeyFrame(new Duration(120), new KeyValue(carte2.scaleYProperty(), 1.05))
        );
        timeline.setAutoReverse(true);
        timeline.setCycleCount(2);

        toursuivant.setDisable(false);
        toursuivant.setText("Tour suivant (1)");
        abandonner.setText("Abandonner");
    }

}
