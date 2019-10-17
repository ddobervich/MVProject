import java.util.ArrayList;

public class WordBucket {
    private ArrayList<String> words;

    public WordBucket() {
        words = new ArrayList<>();
    }

    public void add(String word) {
        words.add(word);
    }

    public void add(String word, long count) {
        for (long a = 0; a < count; a++) {
            add(word);
        }
    }

    public int size() {
        return words.size();
    }

    public long getCountOf(String target) {
        long count = 0;

        for (String word : words) {
            if (word.equals(target)) {
                count++;
            }
        }

        return count;
    }

    public String getMostFreq() {
        if (size() == 0) return "";
        String mostFreq = words.get(0);
        long largestCount = getCountOf(mostFreq);

        for (String word : words) {
            long count = getCountOf(word);
            if (count > largestCount) {
                largestCount = count;
                mostFreq = word;
            }
        }

        return mostFreq;
    }

    public int getNumUnique() {
        ArrayList<String> noRepeats = new ArrayList<>();

        for (String word : words) {
            if (!noRepeats.contains(word)) {
                noRepeats.add(word);
            }
        }

        return noRepeats.size();
    }
}
