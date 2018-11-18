package jeu;

import cartes.Carte;
import cartes.Categorie;
import cartes.figures.*;

import java.util.ArrayList;
import java.util.Random;

public class Jeu {

    private ArrayList<Carte> paquet = new ArrayList<>();
    private Random random = new Random();

    public Jeu() {

        for(Categorie categorie : Categorie.values()) {

            for(int i = 7; i < 10; i++) {
                paquet.add(new Carte(""+i, categorie));
            }
            paquet.add(new Dix(categorie));
            paquet.add(new Valet(categorie));
            paquet.add(new Dame(categorie));
            paquet.add(new Roi(categorie));
            paquet.add(new As(categorie));
        }
    }

    public void demarrer() {

        int score = 0;

        for(int i = 1; i <= 5; i++) {
            System.out.println("TOUR " + i + " : ");

            Carte c1 = paquet.remove(random.nextInt(paquet.size()));
            Carte c2 = paquet.remove(random.nextInt(paquet.size()));

            System.out.println(c1);
            System.out.println(c2);

            int resultat = comparer(c1, c2);
            score += resultat;
            System.out.println("Votre score : " + score + " (" + resultat + ")");
            System.out.println("=======================");
        }
    }

    private int comparer(Carte c1, Carte c2) {
        int resultat = c1.getValeur() + c2.getValeur();

        if(c1.getLibelle().equals(c2.getLibelle())) {
            resultat = -resultat;
            if(c1.getCouleur().equals(c2.getCouleur())) {
                resultat *= 2;
            }
        }

        return resultat;
    }

}
