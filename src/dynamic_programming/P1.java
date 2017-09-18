package dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by alexisherrera on 9/15/17.
 */
public class P1 {
    //count num of score combinations

    //write a program that takes a final score (n) and a list of scores for individual plays
    //find number of combinations of plays that result in final score
    public static int playCombos(int finalScore, List<Integer> playScores, List<Integer> disOne, int start,
                                 HashMap<String, Integer> memo) {


        //we can solve this by doing a depth first search of subtracting different scores from the final
        //score. if we reach 0 return 1 because we found play combination. if we are under 0 return 0;

        if (finalScore == 0) { System.out.println(disOne); return 1; }
        if (finalScore < 0)  { return 0;  }
        if (start >= playScores.size()) { return 0; }


        int sum = 0;
        int play = playScores.get(start);

        //we can memo by using hash-map that maps from index and remaining value.
        String k = finalScore + "-" + start;

        if (memo.containsKey(k)) { return memo.get(k); }

        //go through all the choices assuming a particular number of moves taken by the step
        for (int i = 0; i * play <= finalScore; i++) {


            for (int j = 0; j < i; j++) {
                disOne.add(play);
            }

            sum = sum + playCombos(finalScore - (i * play), playScores, disOne, start + 1, memo);

            for (int j = 0; j < i; j++) {
                disOne.remove(disOne.size() - 1);
            }
        }

        memo.put(k, sum);
        return sum;

        //running time is
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        List<Integer> disOne = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(playCombos(4, l, disOne, 0, new HashMap<>()));
    }
}
