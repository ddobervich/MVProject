import java.lang.reflect.Array;
import java.util.ArrayList;

public class Readability {
    public static void main(String[] args) {

     /*   ArrayList<DocInfo> docs = TextLib.readDocsFile("data/Texts/allfeatures-ose-final.csv");

        for (DocInfo doc : docs) {
            String filename = doc.getFilename();    // "amazon-adv.txt"
            String text = TextLib.readFileAsString("data/Texts/AllTexts/" + filename);

            if (text.length() > 0) {
                ArrayList<String> sentences = TextLib.splitIntoSentences(text);

            }
        }

        String test = TextLib.readFileAsString("data/Texts/AllTexts/Amazon-adv.txt");
        //System.out.println(test);
        ArrayList<String> sentences = TextLib.splitIntoSentences(test);

        double score = FKReadability(sentences);
        System.out.println(score);*/
    }

    private static double FKReadability(ArrayList<String> sentences) {
        double wordCount = 0;
        double syllableCount = 0;

        for (String sentence : sentences) {
            ArrayList<String> words = getWords(sentence);
            wordCount += words.size();

            for (String word : words) {
                syllableCount += syllablesFor(word);
            }
        }

        return 206.835 - 1.01*(wordCount/sentences.size())-
                84.6*(syllableCount/wordCount);
    }

    private static ArrayList<String> getWords(String sentence) {
        ArrayList<String> words = new ArrayList<String>();

        String[] arr = sentence.split(" ");
        for (String word : arr) {
            if (word.length() > 0) {
                words.add(word);
            }
        }

        return words;
    }

    private static int syllablesFor(String testWord) {
        boolean inVowelChain = false;
        int boundaries = 0;

        for (int i = 0; i < testWord.length(); i++) {
            String letter = testWord.substring(i, i+1);
            if (isVowel(letter)) {
                if (!inVowelChain) {
                    inVowelChain = true;
                    boundaries++;
                }
            } else {
                inVowelChain = false;
            }
        }

        return boundaries;
    }

    private static boolean isVowel(String letter) {
        return "aeiouy".contains(letter);
    }
}
