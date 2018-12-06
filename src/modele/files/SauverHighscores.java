package modele.files;

import modele.highscores.Score;
import modele.highscores.Tableau;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class SauverHighscores {
    private static final String HIGHSCORES = "files/highscores.txt";

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
