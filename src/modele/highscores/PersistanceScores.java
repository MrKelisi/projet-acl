package modele.highscores;

import modele.joueurs.Joueur;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersistanceScores {

    private static final String HIGHSCORES = "files/highscores.txt";
    private static final String PATTERN    = "^(.+)\t(-?[0-9]+)\t([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})$";

    /**
     * Lis une ligne du fichier et l'ajoute au tableau des scores
     * @param ligne Ligne du fichier
     * @return Nouveau score lu à partir du fichier
     * @throws ParseException
     * @see Tableau
     */
    private static Score lire(String ligne)
            throws ParseException {

        final Pattern pattern = Pattern.compile(PATTERN);
        final Matcher matcher = pattern.matcher(ligne);
        matcher.find();

        return new Score(
                new Joueur(matcher.group(1)),
                Integer.valueOf(matcher.group(2)),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(matcher.group(3))
        );
    }

    /**
     * Charge un tableau des scores à partir d'un fichier
     * @return Une ArrayList de Score contenant les scores du fichier
     */
    public static ArrayList<Score> charger() {

        ArrayList<Score> scores = new ArrayList<>();

        try {
            File fichierScores = new File(HIGHSCORES);
            if(!fichierScores.exists()) {
                try {
                    fichierScores.getParentFile().mkdirs();
                    fichierScores.createNewFile();
                }
                catch (IOException e) {
                    e.printStackTrace();
                    return scores;
                }
            }
            Scanner sc = new Scanner(fichierScores);
            while(sc.hasNextLine()) {
                try {
                    scores.add(lire(sc.nextLine()));
                } catch (Exception e) {
                    System.err.println("Erreur de lecture de la ligne");
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.err.println("Fichier des scores introuvables");
            e.printStackTrace();
        }

        return scores;
    }

    /**
     * Sauvegarde le tableau des scores dans un fichier
     * @param tableau Tableau des scores
     */
    public static void sauvegarder(Tableau tableau) {
        File file = new File(HIGHSCORES);
        PrintWriter writer;

        try {
            file.createNewFile();
            writer = new PrintWriter(file);
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for(Score score : tableau) {
            writer.print(score.getNom() + "\t" + score.getScore() + "\t" + sdf.format(score.getDate()) + "\n");
        }

        writer.close();
    }

}
