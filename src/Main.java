import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {



        String text = TextLib.readFileAsString("data/count_1w.txt");
        String[] lines = text.split("\n");

        long totalCount = 0;

        for (String line : lines) {
            String[] words = line.split("\\s+");

            long count = Long.parseLong(words[1]);
            totalCount += count;
        }

        PrintWriter fileWriter = new PrintWriter("data/wordFrequencies.txt");

        for (String line : lines) {
            String[] words = line.split("\\s+");
            String word = words[0];
            long count = Long.parseLong(words[1]);
            double freq = (double)count/totalCount;

            fileWriter.println(word + " " + freq);
        }

        fileWriter.close();
    }
}
