package controleurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import vues.VuePlateau;

public class Plateau2Controller {

    private VuePlateau vuePlateau;
    private Stage primaryStage;

    public Plateau2Controller(Stage stage) {
        primaryStage = stage;
        vuePlateau = new VuePlateau(primaryStage);

        vuePlateau.getTourSuivantBtn().setOnAction(new TourSuivantBtnHandler());
    }

    public VuePlateau getVue() {
        return vuePlateau;
    }

    public void show() {
        vuePlateau.show();
    }

    class TourSuivantBtnHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            //piocherCartes();
            System.out.println("Pressé !");
        }
    }

}
