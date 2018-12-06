package files;

import cartes.Carte;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;

import java.io.FileInputStream;

public class ResourcesLoader {

    private static ResourcesLoader instance;
    private static Image paquet;

    private ResourcesLoader() {

        try {
            paquet = new Image(new FileInputStream("resources/cartes/paquet.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new ResourcesLoader();
    }

    public static ResourcesLoader getInstance() {
        return instance;
    }

    public static Image getPaquet() {
        return paquet;
    }

    public Rectangle2D getCarteCoords(Carte carte) {

        String categ = carte.getCategorie().getNom();
        String fig = carte.getFigure().getNom();
        int row, column;

        switch(categ) {
            case "trèfle": row = 0; break;
            case "carreau": row = 1; break;
            case "coeur": row = 2; break;
            case "pique": row = 3; break;
            default: row = 0;
        }
        switch(fig) {
            case "7": column = 0; break;
            case "8": column = 1; break;
            case "9": column = 2; break;
            case "10": column = 3; break;
            case "J": column = 4; break;
            case "Q": column = 5; break;
            case "K": column = 6; break;
            case "A": column = 7; break;
            default: column = 8;
        }

        return new Rectangle2D(column*98, row*143, 98, 143);
    }

}
