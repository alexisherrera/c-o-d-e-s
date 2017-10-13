package searching;

/**
 * Created by alexisherrera on 9/27/17.
 */
public class P4 {
    //compute the integer square root

    //approach we can start at 1 and then keep squaring the value until it is over our target.
    public int bruteforce(int N) {
        int potentialCandidate = 1;
        for (int i = 2; i < N; i++) {
            if (i * i <= N) {
                potentialCandidate = i;
            }
            else if ( i * i > N) { break; }
        }
        //takes O(n) time.
        return potentialCandidate;
    }

    //how can we improve? We can try the element at N/2 then work to the left and right
    //depending on the value. Kinda like binary search

    public int BS(int N) {
        //will do iterative BS

        int lo = 0;
        int hi = N;
        int candidate = 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (mid * mid <= N) {
                candidate = mid;
                lo = mid + 1;
            }
            else {
                hi = mid -1;
            }
        }

        return candidate;







    }
}
