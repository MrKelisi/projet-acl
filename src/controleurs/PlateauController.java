package controleurs;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import modele.cartes.Carte;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;

import javax.annotation.PostConstruct;

public class PlateauController extends DefaultController {

    private Timeline timeline;

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


    @PostConstruct
    public void initialize() {
        timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(carte1.scaleXProperty(), 1)),
                new KeyFrame(Duration.ZERO, new KeyValue(carte1.scaleYProperty(), 1)),
                new KeyFrame(Duration.ZERO, new KeyValue(carte2.scaleXProperty(), 1)),
                new KeyFrame(Duration.ZERO, new KeyValue(carte2.scaleYProperty(), 1)),
                new KeyFrame(new Duration(100), new KeyValue(carte1.scaleXProperty(), 0)),
                new KeyFrame(new Duration(100), new KeyValue(carte1.scaleYProperty(), 1.08)),
                new KeyFrame(new Duration(100), new KeyValue(carte2.scaleXProperty(), 0)),
                new KeyFrame(new Duration(100), new KeyValue(carte2.scaleYProperty(), 1.08))
        );
        timeline.setAutoReverse(true);
        timeline.setCycleCount(2);
    }


    @FXML
    protected void menu(ActionEvent event) {
        vue.changerVue("menu");
    }

    @FXML
    protected void tourSuivant(ActionEvent event) {

        if(jeu.tirer()) {
            timeline.stop();
            timeline.play();
            refreshScene();

            if(jeu.estTermine()) {
                toursuivant.setDisable(true);
                abandonner.setText("Menu principal");
            }
        }
    }

    private void refreshScene() {
        carte1.setViewport(getCarteCoords(jeu.carte(1)));
        carte2.setViewport(getCarteCoords(jeu.carte(2)));

        if(jeu.resultat() > 0) {
            resultat.setText("+" + jeu.resultat());
            resultat.setFill(Color.INDIANRED);
        } else {
            resultat.setText(Integer.toString(jeu.resultat()));
            resultat.setFill(Color.LIMEGREEN);
        }

        score.setText("Votre score : " + jeu.score());
        toursuivant.setText("Tour suivant (" + jeu.tour() + ")");
    }

    private Rectangle2D getCarteCoords(Carte carte) {
        System.out.println(carte);
        return new Rectangle2D(carte.figure().ordinal() * 129, carte.categorie().ordinal() * 185, 129, 185);
    }

    public void demarrer() {
        jeu.demarrer();
        jeu.tirer();
        refreshScene();

        toursuivant.setDisable(false);
        toursuivant.setText("Tour suivant (1)");
        abandonner.setText("Abandonner");

    }

}
