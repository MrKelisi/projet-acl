package cartes;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PaquetCartesFrancais implements PaquetCartes {
    private static final Figure[] figures = {
            new Figure("A", 11),
            new Figure("K", 4),
            new Figure("D", 3),
            new Figure("V", 2),
            new Figure("10", 10),
            new Figure("9", 0),
            new Figure("8", 0),
            new Figure("7", 0),
    };

    private static final Categorie[] categories = {
            new Categorie("noir", "pique"),
            new Categorie("rouge", "coeur"),
            new Categorie("noir", "trèfle"),
            new Categorie("rouge", "carreau"),
    };

    private ArrayList<Carte> cartes;

    public PaquetCartesFrancais() {
        cartes = new ArrayList<>();
        generer();
    }

    @Override
    public void generer() {
        cartes.clear();

        for(Figure figure : figures) {
            for (Categorie categorie : categories) {
                int index;

                try {
                    index = ThreadLocalRandom.current().nextInt(0, cartes.size());
                }
                catch (IllegalArgumentException e) {
                    index = 0;
                }

                cartes.add(index, new Carte(figure, categorie));
            }
        }
    }

    @Override
    public Carte tirerCarte() {
        try {
            return cartes.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            generer();
            return cartes.remove(0);
        }
    }
}
