package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexisherrera on 9/15/17.
 */
public class P1 {
    //count num of score combinations

    //write a program that takes a final score (n) and a list of scores for individual plays
    //find number of combinations of plays that result in final score
    public static int playCombos(int finalScore, List<Integer> playScores, List<Integer> disOne, int start) {


        //we can solve this by doing a depth first search of subtracting different scores from the final
        //score. if we reach 0 return 1 because we found play combination. if we are under 0 return 0;

        if (finalScore == 0) { System.out.println(disOne); return 1; }
        if (finalScore < 0)  { return 0;  }
        if (start >= playScores.size()) { return 0; }


        int sum = 0;
        int play = playScores.get(start);

        //go through all the choices assuming a particular number of moves taken by the step
        for (int i = 0; i * play <= finalScore; i++) {


            for (int j = 0; j < i; j++) {
                disOne.add(play);
            }

            sum = sum + playCombos(finalScore - (i * play), playScores, disOne, start + 1);

            for (int j = 0; j < i; j++) {
                disOne.remove(disOne.size() - 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        List<Integer> disOne = new ArrayList<>();
        l.add(2);
        l.add(3);
        l.add(7);
        System.out.println(playCombos(12, l, disOne, 0));
    }
}
