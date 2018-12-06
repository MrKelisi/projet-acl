package controleurs;

import modele.jeu.JeuBelote;
import vues.Vue;

public abstract class DefaultController {

    protected JeuBelote jeu;
    protected Vue vue;

    public void setJeu(JeuBelote jeu) {
        this.jeu = jeu;
    }
    public void setVue(Vue vue) {
        this.vue = vue;
    }

}
