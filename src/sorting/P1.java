package sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexisherrera on 9/11/17.
 */
public class P1 {
    //intersection of two arrays

    //given 2 sorted arrays lets return a list of the intersection of the two arrays
    public static ArrayList<Integer> intersection(int[] l1, int[] l2) {
        //use a hashset to get intersection
        Set<Integer> set = new HashSet<>();

        ArrayList<Integer> intersection = new ArrayList<>();


        int[] smaller = l1.length <= l2.length ? l1 : l2;
        int[] larger = l1.length > l2.length ? l1 : l2;

        //iterate through smaller first to avoid adding all elements of larger in the set
        for (int i = 0; i < smaller.length; i++) {
            if (!set.contains(smaller[i])) { set.add(smaller[i]); }
        }

        //iterate through second array and find intersection
        for (int i = 0; i < larger.length; i++) {
            if (set.contains(larger[i])) {
                intersection.add(larger[i]);
                set.remove(larger[i]);
            }
        }

        return intersection;

        //runs in O(n) time and uses up to O(y) space, where y is the length of smallest array.

        //can we improve the space complexity? we can iterate by values together using a while loop and

    }

    public static ArrayList<Integer> intersectionImprovedSpaceComplexity(int[] l1, int[] l2) {
        ArrayList<Integer> intersection = new ArrayList<>();

        int indexL1 = 0;
        int indexL2 = 0;

        //we will iterate through the



    }

    public static void main(String[] args) {
        int[] l1 = { 4, 7, 19, 20, 600};
        int[] l2 = { 7, 7 , 600, 900};

        System.out.println(intersection(l1, l2));
    }

}
