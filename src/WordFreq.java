public class WordFreq {
    private String word;
    private long count;

    public WordFreq(String word, long count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void addToCount(long toAdd) {
        count += toAdd;
    }
}
