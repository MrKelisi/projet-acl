package vues.boutons;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Bouton extends JButton implements ObservableBouton {

    private ArrayList<ObserverBouton> observers = new ArrayList<>();

    protected Bouton(String label) {
        super(label);
        this.addActionListener((actionEvent) -> notifyObservers());
    }

    private void notifyObservers() {
        for(ObserverBouton ob : observers) {
            ob.update(this, null);
        }
    }

    @Override
    public void addObserver(ObserverBouton ob) {
        observers.add(ob);
    }
}
