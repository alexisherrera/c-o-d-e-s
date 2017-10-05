package hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexisherrera on 10/5/17.
 */
public class P11 {
    //compute all string decompositions

    public static int allStringDecomp(String sentence, String[] words) {

        //firstly, create a map of all the words and their frequency
        Map<String, Integer> wordToFreq = new HashMap<>();

        //pop map
        for (String s: words) {
            if (wordToFreq.containsKey(s)) {
                wordToFreq.put(s, wordToFreq.get(s) + 1);
            }
            else {
                wordToFreq.put(s, 1);
            }
        }

        int lengthOfWords = words[0].length();
        int lengthOfConcat = lengthOfWords * words.length;

        //now we will iterate through the sentence and check for substrings
        for (int i = 0; i < sentence.length() && lengthOfConcat + i - 1 < sentence.length();
             i++) {
            String sub = sentence.substring(i, i + lengthOfWords);

            //check if initial word is contained in our map
            if (wordToFreq.containsKey(sub)) {

                //check if we can construct the current substring from the
                if (isConstructable(i, lengthOfConcat, lengthOfWords, new HashMap<>(wordToFreq), sentence)) { return i; }
            }

        }
        return -1;
    }

    public static boolean isConstructable(int beginning, int length, int wordLength,
                                          HashMap<String, Integer> wordToFreq, String sentence) {

        for (int i = beginning; i + wordLength <= sentence.length(); i = i + wordLength) {

            String sub = sentence.substring(i, i + wordLength);
            if (!wordToFreq.containsKey(sub)) { return false; }
            else {
                if (wordToFreq.get(sub) == 1) {
                    wordToFreq.remove(sub);
                }
                else {
                    wordToFreq.put(sub, wordToFreq.get(sub) - 1);
                }
            }
        }
        return wordToFreq.isEmpty();

        //running time is O(Nmn), N is length of array, m is number of words, and n is the length of each word
        //O(mn) space --> at most we are using two hashmaps of size O(mn)
    }

    public static void main(String[] args) {
        String sent = "amanaplanacanal";
        String[] words = {"can", "apl", "ana"};

        //should be 4
        System.out.println(allStringDecomp(sent,words));
    }

}
