package arrays;
import java.util.ArrayList;

/**
 * Created by alexisherrera on 8/28/17.
 */
public class P9 {
    //enumerate all primes to n

    //take an int and find all primes between 1 and the integer

    //approach: my initial thoughts are to find all numbers from 2 to integer n. for each number check if it is a prime
    //by dividing by every number betweeen 2 and the square root of the integer

    public static boolean isPrime(int n) {
        if (n == 1) {
            return true;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static ArrayList<Integer> enumerateAllPrimes(int n) {
        ArrayList<Integer> listOfPrimes = new ArrayList<>();
        boolean[] possiblePrimes = new boolean[n + 1];

        for (int i = 2; i < n + 1; i++) {
            possiblePrimes[i] = true;
        }

        for (int i = 2; i < n + 1; i++) {
            if (!possiblePrimes[i]) { continue; }
            listOfPrimes.add(i);
            for (int j = i; j < n + 1; j = j + i) {
                possiblePrimes[j] = false;
            }

        }
        return listOfPrimes;
    }


    public static void main(String[] args) {
        ArrayList<Integer> primes = enumerateAllPrimes(101);
        System.out.println(primes);
    }
}
