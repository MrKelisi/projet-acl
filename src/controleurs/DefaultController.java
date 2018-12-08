package controleurs;

import modele.jeu.JeuBelote;
import vues.Fenetre;
import vues.Vue;

public abstract class DefaultController {
    protected Fenetre fenetre;
    protected JeuBelote jeu;

    public void setJeu(JeuBelote jeu) {
        this.jeu = jeu;
    }
    public void setFenetre(Fenetre fenetre) {
        this.fenetre = fenetre;
    }
}
