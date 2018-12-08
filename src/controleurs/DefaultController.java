package controleurs;

import modele.jeu.JeuBelote;
import vues.Fenetre;

public abstract class DefaultController {
    protected Fenetre fenetre;
    protected JeuBelote jeu;

    /**
     * Défini le jeu associé au controleur
     * @param jeu Jeu à controler
     */
    public void setJeu(JeuBelote jeu) {
        this.jeu = jeu;
    } //TODO: utiliser l'interface ici ?

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
