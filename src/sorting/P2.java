package sorting;

/**
 * Created by alexisherrera on 9/11/17.
 */
public class P2 {

    //merge two sorted arrays (merge step in mergesort). first array can hold all elements together
    public static void mergeStep(int[] l1, int[] l2, int lengthL1, int lengthL2) {
        //we can do normal merge step but the problem is swaps. we want to minimize swaps and shifting elements
        //doing that increases our time complexity proportional to the length of the combined array.

        //to solve this lets start at the end of l1 and instead of considering what element is the smallest of
        //the two arrays we consider the largest element of the two and put it at the end of l1
        int index = l1.length - 1;

        int l1Index = lengthL1 - 1;
        int l2Index = lengthL2 - 1;

        //move elements while we can iterate on both arrays
        while (l1Index >= 0 && l2Index >= 0) {
            //put element in l1 at the end of array
            if (l1[l1Index] >= l2[l2Index]) {
                l1[index] = l1[l1Index];
                index--;
                l1Index--;
            }
            else if (l1[l1Index] < l2[l2Index]) {
                l1[index] = l2[l2Index];
                index--;
                l2Index--;
            }
        }

        //this first while loop is redundant. if there are left over elements in list1 they are already sorted.
        while (l1Index >= 0) {
            l1[index] = l1[l1Index];
            index--;
            l1Index--;
        }
        while (l2Index >= 0) {
            l1[index] = l2[l2Index];
            index--;
            l2Index--;
        }


        //this function will take O(n + m) because we iterate through both arrays, find the largest element and put at
        //the end. all of this takes O(1) time and we do this for all entries in the 2 arrays.
    }


    public static void main(String[] args) {
    }


}
