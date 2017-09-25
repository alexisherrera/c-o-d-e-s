package dynamic_programming;

import java.util.ArrayList;
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
        return knapsackProb(clocks, 0, weightConstraint);
    }


    public static int knapsackProb(List<Clock> clocks, int index, int weightLeft) {
        if (weightLeft <= 0) { return 0; }
        if (index >= clocks.size()) { return 0; }

        Clock currClock = clocks.get(index);
        int currMaxVal = 0;
        //including current clock (if we can)
        if (weightLeft - currClock.weight >= 0) {
            currMaxVal = knapsackProb(clocks, index + 1, weightLeft - currClock.weight) + currClock.value;
        }

        //or excluding current clock (we do not reduce weight)
        currMaxVal = Math.max(currMaxVal, knapsackProb(clocks, index + 1, weightLeft));
        return currMaxVal;
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
