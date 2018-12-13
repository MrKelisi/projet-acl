package controleurs;

import vues.Fenetre;
import vues.Vue;

public abstract class Controleur {

    protected Fenetre fenetrePrincipale;

    protected Controleur(Fenetre fenetre) {
        fenetrePrincipale = fenetre;
    }

    /**
     * Retourne la vue associée à ce controleur
     */
    public abstract Vue getVue();

}
