package arrays;

/**
 * Created by alexisherrera on 8/28/17.
 */
public class PrimeCheck {

    //check if a number is a prime. I guess this a right of passage program that I never really got around to writing

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;

        //complexity of this number is O(n), where n is the number given. we check all entries from 2 -> n - 1.
    }


    public static void main(String[] args) {
        int prime = 619;
        int non_prime = 314;

        System.out.println(isPrime(prime));
        System.out.println(isPrime(non_prime));
    }

}
