package controleurs;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import modele.belote.JeuBelote;
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
        JoueurActif.reset();
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
        JeuBelote jeu = JoueurActif.getInstance().getJeu();
        carte1.setViewport( getCarteCoords(jeu.getCarte1()) );
        carte2.setViewport( getCarteCoords(jeu.getCarte2()) );

        if(jeu.getResultat() > 0) {
            resultat.setText("+" + jeu.getResultat());
            resultat.setFill(Color.INDIANRED);
        } else {
            resultat.setText(Integer.toString(jeu.getResultat()));
            resultat.setFill(Color.LIMEGREEN);
        }

        score.setText("Votre score : " + JoueurActif.getInstance().score());
        tour.setText("Tour n°" + JoueurActif.getInstance().tour());
    }

    /**
     * Calcule les coordonnées de la carte désirée sur l'asset
     * @param carte La carte souhaitée
     * @return Coordonnées sur l'asset des cartes
     */
    private Rectangle2D getCarteCoords(CarteAJouer carte) {
        return new Rectangle2D(carte.figure().ordinal() * 129, carte.enseigne().ordinal() * 185, 129, 185);
    }

    @Override
    public void init() {
        super.init();

        piocherCartes();

        toursuivant.setVisible(true);
        abandonner.setText("Abandonner");
    }
}
