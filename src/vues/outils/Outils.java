package vues.outils;

import java.awt.*;

public class Outils {

    public static void place(Frame frame, double Ox, double Oy, double largeur, double hauteur) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension screenSize = toolkit.getScreenSize();

        frame.setLocation((int)(screenSize.width*Ox),(int)(screenSize.height*Oy));
        frame.setSize((int)(screenSize.width*largeur), (int)(screenSize.height*hauteur));
    }
}
