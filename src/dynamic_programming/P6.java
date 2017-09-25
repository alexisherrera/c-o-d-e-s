package dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by alexisherrera on 9/25/17.
 */
public class P6 {
    //the knapsack problem

    //we are utilizing clocks
    public static int findMaxValue(List<Clock> clocks, int weightConstraint) {
        //if greedy solutions do not work maybe we can try all subsets that satisfy weight constraint
        //and choose the largest one.

        //for instance, iterate through the clocks selecting and not selecting a particular clock while
        //we can still satisfy the weigh constraint. This is equivilant to finding all subsets, but with the
        //constraint that we stop if we cannot add any other clock.
        HashMap<String, Integer> memo = new HashMap<>();
        return knapsackProb(clocks, 0, weightConstraint, memo);
    }


    public static int knapsackProb(List<Clock> clocks, int index, int weightLeft, HashMap<String, Integer> memo) {
        if (weightLeft <= 0) { return 0; }
        if (index >= clocks.size()) { return 0; }

        String k = "" + index + "-" + weightLeft;

        if (memo.containsKey(k)) { return memo.get(k); }

        Clock currClock = clocks.get(index);
        int currMaxVal = 0;
        //including current clock (if we can)
        if (weightLeft - currClock.weight >= 0) {
            currMaxVal = knapsackProb(clocks, index + 1, weightLeft - currClock.weight, memo) + currClock.value;
        }

        //or excluding current clock (we do not reduce weight)
        currMaxVal = Math.max(currMaxVal, knapsackProb(clocks, index + 1, weightLeft, memo));
        memo.put(k, currMaxVal);
        System.out.println("SIZE OF MAP: " + memo.size());
        return currMaxVal;

        //we can easily memo using the arguments, if we are at a particular index and the weightLeft is the same,
        //we should know what the max is. Therefore, we can use a hashtable, where our key is the index-weightleft
        //and value is the maximum value we can hold.

        //This reduces our running time complexity to O(num of subproblems * RT of each). RT of each sub problem is
        //O(1)-- it is simple arithmetic. the number of subproblems is the different combinations of index and weight-left,
        //which is dependent on clocks. At most, all clocks can fit in the knapsack, giving this a running time of
        // O(numClocks * Weight)
    }


    public static void main(String[] args) {
        Clock c1 = new Clock(5, 60);
        Clock c2 = new Clock(3, 50);
        Clock c3 = new Clock(4, 70);
        Clock c4 = new Clock(2, 30);

        List<Clock> l = new ArrayList<>();
        l.add(c1); l.add(c2); l.add(c3); l.add(c4);

        //should be 80
        System.out.println(findMaxValue(l, 5));
    }
}
