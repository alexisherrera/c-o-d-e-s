package leetcode;
import java.util.*;

/**
 * Created by alexisherrera on 10/30/17.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordsToVisit = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int length = 1;

        //add strings to the set
        for (String s : wordList) {
            wordsToVisit.add(s);
        }

        q.add(beginWord);

        //BFS
        while (!q.isEmpty()) {
            int sizeOfLevel = q.size();
            for (int k = 0; k < sizeOfLevel; k++) {
                String currWord = q.poll();

                for (int i = 0; i < currWord.length(); i++) {
                    char[] cWordArr = currWord.toCharArray();

                    for (int j = 0; j < 26; j++) {
                        cWordArr[i] = (char) ((int)'a' + j);

                        String nWord = new String(cWordArr);
                        if (nWord.equals(endWord) && wordsToVisit.contains(nWord)) { return length + 1; }
                        if (wordsToVisit.contains(nWord)) {
                            q.add(nWord);
                            wordsToVisit.remove(nWord);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
}
