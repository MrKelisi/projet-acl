package vues;

import java.awt.*;
import vues.outils.*;

public class Plateau extends Frame {

    private EcouteurTerminaison ecouteurTerminaison;

    public Plateau(String titre) {
        super(titre);

        ecouteurTerminaison = new EcouteurTerminaison(this);
        Outils.place(this, 0.1,0.1,0.8,0.8);
    }

    public void afficher() {
        this.setVisible(true);
    }

}
