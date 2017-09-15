package dynamic_programming;

import java.util.HashMap;

/**
 * Created by alexisherrera on 9/15/17.
 */
public class Fibonacci {

    //classic fibonacci dp example
    public static int fib(int n, HashMap<Integer, Integer> cache) {
        //if 0 or 1 return
        if (n == 0 || n== 1) {
            return n;
        }
        else {

            //retrieve value from the hashtable which maps n --> fib #
            if (cache.containsKey(n)) {
                return cache.get(n);
            }
            //if hasn't been previously computed, compute recursively, but save it so we don't ever have to do this
            //work again
            int updatedFib = fib(n - 1, cache) + fib(n - 2, cache);
            cache.put(n, updatedFib);
            return updatedFib;
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(8, new HashMap<>()));
    }
}
