package controleurs;

import modele.belote.JeuBelote;
import vues.Fenetre;

public abstract class BaseController {
    protected Fenetre fenetre;

    /**
     * Ajoute la fenêtre associé à la vue de ce controleur
     * @param fenetre Fenêtre de la vue de ce controleur
     */
    public void setFenetre(Fenetre fenetre) {
        this.fenetre = fenetre;
    }

    /**
     * Initialise la vue
     */
    public void init() {}
}
