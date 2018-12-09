package controleurs;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import modele.belote.ResultatTirage;
import modele.cartes.CarteAJouer;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import modele.belote.JoueurActif;

import javax.annotation.PostConstruct;

public class PlateauController extends BaseController {

    private Timeline timeline;

    @FXML
    private ImageView carte1;
    @FXML
    private ImageView carte2;
    @FXML
    private Text tour;
    @FXML
    private Text resultat;
    @FXML
    private Text score;
    @FXML
    private Button toursuivant;
    @FXML
    private Button abandonner;


    /**
     * Initialise la vue à l'instanciation pour définir les animations sur les objets
     */
    @PostConstruct
    public void initialize() {
        timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(carte1.scaleXProperty(), 0)),
                new KeyFrame(Duration.ZERO, new KeyValue(carte1.scaleYProperty(), 1.1)),
                new KeyFrame(Duration.ZERO, new KeyValue(carte2.scaleXProperty(), 0)),
                new KeyFrame(Duration.ZERO, new KeyValue(carte2.scaleYProperty(), 1.1)),
                new KeyFrame(new Duration(120), new KeyValue(carte1.scaleXProperty(), 1)),
                new KeyFrame(new Duration(120), new KeyValue(carte1.scaleYProperty(), 1)),
                new KeyFrame(new Duration(120), new KeyValue(carte2.scaleXProperty(), 1)),
                new KeyFrame(new Duration(120), new KeyValue(carte2.scaleYProperty(), 1))
        );
        timeline.setCycleCount(1);
    }


    @FXML
    protected void afficherMenuPrincipal() {
        fenetre.setVue("menu");
    }

    @FXML
    protected void piocherCartes() {
        if(JoueurActif.getInstance().tirer()) {
            timeline.stop();
            timeline.play();
            refreshScene();

            if(JoueurActif.getInstance().aTermine()) {
                JoueurActif.getInstance().sauvegarder();
                toursuivant.setVisible(false);
                abandonner.setText("Menu principal");
            }
        }
    }

    /**
     * Rafraichit la scène
     */
    private void refreshScene() {
        ResultatTirage resultatTirage = JoueurActif.getInstance().getResultatDernierTirage();
        carte1.setViewport( getCarteCoords(resultatTirage.getCarte1()) );
        carte2.setViewport( getCarteCoords(resultatTirage.getCarte2()) );

        if(resultatTirage.getResultat() > 0) {
            resultat.setText("+" + resultatTirage.getResultat());
            resultat.setFill(Color.INDIANRED);
        } else {
            resultat.setText(Integer.toString(resultatTirage.getResultat()));
            resultat.setFill(Color.LIMEGREEN);
        }

        score.setText("Votre score : " + JoueurActif.getInstance().score());
        tour.setText("Tour n°" + JoueurActif.getInstance().tour());
    }

    /**
     * Calcule les coordonnées de la carte désirée sur l'asset
     * @param carte CarteAJouer désirée
     * @return Coordonnées sur l'asset de carte
     */
    private Rectangle2D getCarteCoords(CarteAJouer carte) {
        return new Rectangle2D(carte.figure().ordinal() * 129, carte.categorie().ordinal() * 185, 129, 185);
    }

    @Override
    public void init() {
        super.init();

        piocherCartes();

        toursuivant.setVisible(true);
        abandonner.setText("Abandonner");
    }
}
