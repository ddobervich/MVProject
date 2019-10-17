import java.util.ArrayList;

public class WordBucket3 {
    private ArrayList<WordFreq> entries;

    public WordBucket3() {
        entries = new ArrayList<WordFreq>();
    }

    public void add(String word){
        int index = getIndexFor(word);

        if (index == -1) {
            WordFreq item = new WordFreq(word,1);
            entries.add(item);
            index = entries.size()-1;
        } else {
            WordFreq item = entries.get(index);
            item.addToCount(1);
        }

        sortItemAt(index);
    }

    public void add(String word, long count) {
      for (long i = 0; i < count; i++) {
          add(word);
      }
    }

    public long size() {
        long count = 0;

        for (WordFreq entry : entries) {
            count += entry.getCount();
        }

        return count;
    }

    public long getCountOf(String target) {
       WordFreq entry = getEntryFor(target);
       if (entry != null) return entry.getCount();

       return 0;
    }

    private WordFreq getEntryFor(String target) {
        int loc = getIndexFor(target);
        if (loc == -1) return null;
        return entries.get(loc);
    }

    public String getMostFreq() {
       if (size()==0) return "";
       return entries.get(0).getWord();
    }

    public int getNumUnique() {
       return entries.size();
    }

    /***
     * Move WordFreq obj at index into sorted order in entries
     * @param index
     */
    private void sortItemAt(int index) {
        while (index > 0 && entries.get(index).getCount() > entries.get(index-1).getCount()) {
            swapElements(entries, index, index-1);
        }
    }

    private void swapElements(ArrayList<WordFreq> entries, int i, int j) {
        WordFreq entry1 = entries.get(i);
        WordFreq entry2 = entries.get(j);

        entries.set(i, entry2);
        entries.set(j, entry1);
    }

    private int getIndexFor(String word) {
        for (int i = 0; i < entries.size(); i++) {
            WordFreq entry = entries.get(i);

            if (entry.getWord().equals(word)) return i;
        }

        return -1;
    }
}
