package dynamic_programming;

import java.util.List;

/**
 * Created by alexisherrera on 9/15/17.
 */
public class P1 {
    //count num of score combinations

    //write a program that takes a final score (n) and a list of scores for individual plays
    //find number of combinations of plays that result in final score
    public static int playCombos(int finalScore, List<Integer> playScores) {


        //we can solve this by doing a depth first search of subtracting different scores from the final
        //score. if we reach 0 return 1 because we found play combination. if we are under 0 return 0;

        if (finalScore == 0) { return 1; }
        if (finalScore < 0)  { return 0;  }


        int sum = 0;
        for (Integer i : playScores) {
            sum = sum + playCombos(finalScore - i, playScores);
        }
        return sum;
    }
}
