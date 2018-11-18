package files;

import highscores.Score;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ParseurHighscores {

    private static final String HIGHSCORES = "files/highscores.txt";
    private static final String PATTERN    = "^([A-Za-z0-9 ]+), (-?[0-9]+)$";

    public ParseurHighscores() {
    }

    private static Score lire(String ligne) {
        final Pattern pattern = Pattern.compile(PATTERN);
        final Matcher matcher = pattern.matcher(ligne);
        matcher.find();
        return new Score(matcher.group(1), Integer.valueOf(matcher.group(2)));
    }


    public static ArrayList<Score> charger() {

        ArrayList<Score> scores = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(HIGHSCORES));
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

}
