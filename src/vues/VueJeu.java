package vues;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import modele.belote.JoueurActif;
import modele.cartes.Carte;

import java.util.Observable;

public class VueJeu extends Vue {

    private ImageView carte1;
    private ImageView carte2;
    private Text resultat;
    private Text tour;
    private Text score;

    private Button tourSuivant;
    private Button abandonner;

    private Timeline animations;

    public VueJeu() {

        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setVgap(15);

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

        FlowPane resultatPane = new FlowPane();
        resultatPane.setAlignment(Pos.CENTER);
        resultatPane.setPrefWidth(60);
        topGrid.add(resultatPane, 1, 0);

        resultat = new Text("0");
        resultat.setFont(Font.font(24));
        resultatPane.getChildren().add(resultat);

        //-------------------------------------------------------------------------------------------------------

        FlowPane middlePane = new FlowPane();
        middlePane.setAlignment(Pos.CENTER);
        middlePane.setOrientation(Orientation.VERTICAL);
        middlePane.setColumnHalignment(HPos.CENTER);
        middlePane.setPrefWrapLength(Double.NaN);
        middlePane.setVgap(5);
        mainGrid.add(middlePane,0,1);

        tour = new Text("Tour n°0");
        tour.setFont(Font.font(14));
        tour.setFill(Color.valueOf("0e61ff"));
        middlePane.getChildren().add(tour);

        score = new Text("Votre score : 0");
        score.setFont(Font.font(17));
        score.setFill(Color.valueOf("0e61ff"));
        middlePane.getChildren().add(score);

        //-------------------------------------------------------------------------------------------------------

        GridPane bottomGrid = new GridPane();
        bottomGrid.setAlignment(Pos.CENTER);
        bottomGrid.setHgap(20);
        mainGrid.add(bottomGrid, 0, 2);

        tourSuivant = new Button("Tour suivant");
        bottomGrid.add(tourSuivant, 0, 0);

        abandonner = new Button("Abandonner");
        bottomGrid.add(abandonner, 1, 0);

        scene = new Scene(mainGrid, WIDTH, HEIGHT);

        initAnimations();
    }

    public Button getTourSuivantBtn() {
        return tourSuivant;
    }

    public Button getAbandonnerBtn() {
        return abandonner;
    }

    private void initAnimations() {
        animations = new Timeline();
        animations.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(carte1.scaleXProperty(), 0)),
                new KeyFrame(Duration.ZERO, new KeyValue(carte1.scaleYProperty(), 1.1)),
                new KeyFrame(Duration.ZERO, new KeyValue(carte2.scaleXProperty(), 0)),
                new KeyFrame(Duration.ZERO, new KeyValue(carte2.scaleYProperty(), 1.1)),
                new KeyFrame(new Duration(100), new KeyValue(carte1.scaleXProperty(), 1)),
                new KeyFrame(new Duration(100), new KeyValue(carte1.scaleYProperty(), 1)),
                new KeyFrame(new Duration(100), new KeyValue(carte2.scaleXProperty(), 1)),
                new KeyFrame(new Duration(100), new KeyValue(carte2.scaleYProperty(), 1))
        );
        animations.setCycleCount(1);
    }

    private Rectangle2D getCarteCoords(Carte carte) {
        return new Rectangle2D(carte.figure().ordinal() * 129, carte.enseigne().ordinal() * 185, 129, 185);
    }

    private void refresh(JoueurActif joueur) {
        if(joueur.aTermine()) {
            tourSuivant.setVisible(false);
            abandonner.setText("Menu principal");
        }

        carte1.setViewport(getCarteCoords(joueur.getJeu().getCarte1()));
        carte2.setViewport(getCarteCoords(joueur.getJeu().getCarte2()));

        int res = joueur.getJeu().getResultat();
        if(res > 0) {
            resultat.setFill(Color.INDIANRED);
            resultat.setText("+" + res);
        } else {
            resultat.setFill(Color.LIMEGREEN);
            resultat.setText(Integer.toString(res));
        }

        tour.setText("Tour n°" + joueur.tour());
        score.setText("Votre score : " + joueur.score());

        animations.stop();
        animations.play();
    }

    @Override
    public void init() {
        tourSuivant.setVisible(true);
        abandonner.setText("Abandonner");
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof JoueurActif) {
            refresh((JoueurActif) arg);
        }
    }
}
