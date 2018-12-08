package controleurs;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import modele.cartes.Carte;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import modele.joueurs.JoueurActif;

import javax.annotation.PostConstruct;

public class PlateauController extends DefaultController {

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

        if(jeu.estTermine()) {
            jeu.sauvegarder();
            fenetre.setVue("highscores");
        }

        if(jeu.tirer()) {
            timeline.stop();
            timeline.play();
            refreshScene();

            if(jeu.estTermine()) {
                toursuivant.setText("Sauvegarder");
            }
        }
    }

    /**
     * Rafraichi la scène
     */
    private void refreshScene() {
        carte1.setViewport( getCarteCoords(JoueurActif.carte(1)) );
        carte2.setViewport( getCarteCoords(JoueurActif.carte(2)) );

        if(JoueurActif.resultat() > 0) {
            resultat.setText("+" + JoueurActif.resultat());
            resultat.setFill(Color.INDIANRED);
        } else {
            resultat.setText(Integer.toString(JoueurActif.resultat()));
            resultat.setFill(Color.LIMEGREEN);
        }

        score.setText("Votre score : " + JoueurActif.score());
        tour.setText("Tour n°" + JoueurActif.tour());
    }

    /**
     * Calcule les coordonnées de la carte désirée sur l'asset
     * @param carte Carte désirée
     * @return Coordonnées sur l'asset de carte
     */
    private Rectangle2D getCarteCoords(Carte carte) {
        return new Rectangle2D(carte.figure().ordinal() * 129, carte.categorie().ordinal() * 185, 129, 185);
    }

    @Override
    public void init() {
        super.init();

        piocherCartes();

        toursuivant.setText("Tour suivant");
        abandonner.setText("Abandonner");
    }
}
