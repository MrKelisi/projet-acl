package controleurs;

import vues.Fenetre;

public abstract class BaseController {
    protected Fenetre fenetre;

    /**
     * Ajoute la fenêtre associée à la vue de ce contrôleur
     * @param fenetre Fenêtre de la vue de ce contrôleur
     */
    public void setFenetre(Fenetre fenetre) {
        this.fenetre = fenetre;
    }

    /**
     * Initialise la vue
     */
    public void init() {}
}
