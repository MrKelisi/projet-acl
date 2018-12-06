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
            paquet = new Image(new FileInputStream("src/resources/paquet.png"));
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

    public static Rectangle2D getDosCoord() {
        return new Rectangle2D(100 * 2,156 * 4,100,156);
    }

    public static Rectangle2D getCarteCoords(Carte carte) {

        int row, column;

        switch(carte.getCategorie().getNom()) {
            case "trèfle": row = 0; break;
            case "carreau": row = 1; break;
            case "coeur": row = 2; break;
            case "pique": row = 3; break;
            default: row = 4;
        }
        switch(carte.getFigure().getNom()) {
            case "7": column = 6; break;
            case "8": column = 7; break;
            case "9": column = 8; break;
            case "10": column = 9; break;
            case "J": column = 10; break;
            case "Q": column = 11; break;
            case "K": column = 12; break;
            case "A": column = 0; break;
            default: column = 1;
        }

        return new Rectangle2D(column*100, row*156, 100, 156);
    }

}
