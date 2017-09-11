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

        //we will iterate through the two arrays simultaneously using a while loop.
        //if we find that both elements are the same value we will add to intersection. if not we
        //will update indices until they are at a new value.
        while (indexL1 < l1.length && indexL2 < l2.length) {
            //check if they are the same value
            if (l1[indexL1] == l2[indexL2] && ((intersection.size() > 0 &&
                    intersection.get(intersection.size() - 1) !=  l1[indexL1]) || intersection.size() == 0)) {
                intersection.add(l1[indexL1]);

                //update indices
                indexL1++;
                indexL2++;

                //continue is critical because then it will go to the other conditionals
                continue;
            }

            //lets update the smaller value's index by 1
            if (l1[indexL1] < l2[indexL2]) {
                indexL1++;
            }
            else if (l1[indexL1] > l2[indexL2]) {
                indexL2++;
            }
        }

        return intersection;
    }


    public static void main(String[] args) {
        int[] l1 = { 4, 7, 19, 20, 600};
        int[] l2 = { 7, 7 , 600, 900};

        System.out.println(intersectionImprovedSpaceComplexity(l1, l2));
    }

}
