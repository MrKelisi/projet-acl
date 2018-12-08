package controleurs;

import modele.jeu.JeuBelote;
import vues.Fenetre;

public abstract class DefaultController {
    protected Fenetre fenetre;
    protected JeuBelote jeu;

    public void setJeu(JeuBelote jeu) {
        this.jeu = jeu;
    } //TODO: utiliser l'interface ici ?
    public void setFenetre(Fenetre fenetre) {
        this.fenetre = fenetre;
    }
    public void init() {

    }
}
