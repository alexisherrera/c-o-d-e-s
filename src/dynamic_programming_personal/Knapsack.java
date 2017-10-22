package dynamic_programming_personal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by alexisherrera on 10/21/17.
 */
public class Knapsack {
    //item private class
    private static class Item {
        int weight;
        int value;
        public Item(int w, int v) {
            weight = w;
            value = v;
        }
    }

    //find maximum value from a list of items with weight constraint
    public static int maxValue(List<Item> items, int maxWeight) {
        int[][] dp = new int[items.size()][maxWeight + 1];

        for (int col = 0; col < dp[0].length; col++) {
            for (int row = 0; row < dp.length; row++) {

                //either we include the element or we do not
                if (row > 0 && items.get(row).weight <= col) {
                    dp[row][col] = Math.max(dp[row - 1][col - items.get(row).weight] + items.get(row).value, dp[row - 1][col]);
                }
                else if (row > 0 && items.get(row).weight > col) {
                    dp[row][col] = dp[row - 1][col];
                }
                else if (row == 0 && items.get(row).weight <= col) {
                    dp[row][col] = items.get(row).value;
                }
                else {
                    dp[row][col] = 0;
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    //testing method
    public static void main(String[] args) {
        Item a = new Item(1,1);
        Item b = new Item(3,4);
        Item c = new Item(4,5);
        Item d = new Item(5,7);
        List<Item> items = new ArrayList<>();
        items.add(a);
        items.add(b);
        items.add(c);
        items.add(d);

        System.out.println(maxValue(items, 7));
    }
}
