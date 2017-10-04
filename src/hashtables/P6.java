package hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexisherrera on 10/4/17.
 */
public class P6 {

    //find nearest repeated entries in an array

    public static EntryPair nearestPair(String[] words) {

        Map<String, Integer> wordToIndex = new HashMap<>();

        EntryPair nearestPair = null;
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (!wordToIndex.containsKey(word)) {
                wordToIndex.put(word, i);
            }
            else {
                int currD = i - wordToIndex.get(word);
                if (currD < distance) {
                    distance = currD;
                    nearestPair = new EntryPair(wordToIndex.get(word), i, word);
                }
                //update current index
                wordToIndex.put(word, i);
            }
        }

        return nearestPair;
        //running time complexity is O(nm), where m is length of longest string.
        //space is O(nm) --> if all words are distint, m is length
    }


    public static void main(String[] args) {
        String[] words = {"All", "work", "and", "no", "play", "makes", "for", "no", "work", "no", "fun", "and",
                            "no", "results"};
        EntryPair result = nearestPair(words);

        System.out.println("first index: " + result.i);
        System.out.println("second index: " + result.j);
        System.out.println("index distance: " + (result.j - result.i));
        System.out.println("word: " + result.word);
    }
}
