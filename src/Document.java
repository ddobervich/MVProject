import java.util.ArrayList;

public class Document {
    private String text;
    private ArrayList<String> sentences;
    private boolean isSentencesUpdated = true;

    private static WordBucket commonWords = new WordBucket();


    public static Document getDocument(String filepath) {
        String text = TextLib.readFileAsString(filepath);
        Document d = new Document(text);
        return d;
    }

    public Document(String text) {
        this.text = text;
        loadWordFrequenciesDoc(commonWords);
    }

    private void loadWordFrequenciesDoc(WordBucket commonWords) {

    }

    public void setText(String n) {
        this.text = n;
        this.isSentencesUpdated = false;
    }

    public int getSentenceCount() {
        if (!isSentencesUpdated) updateSentences();
        return sentences.size();
    }




    private void updateSentences() {

    }

    public int getWordCount() {
        return 0;
    }


}

