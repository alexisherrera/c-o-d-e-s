package arrays;

/**
 * Created by alexisherrera on 8/16/17.
 */
public class P2 {

    //increment an arbitrary-precision integer

    //approach: we take the given array and add one starting from the least significant place.
    //from there if the value is not 9, we simply increment by 1. If it is, we turn the value to 0, and
    //carry over the 1, until we reach an index that is not 9. If we reach the end of the array (index < 0), then
    //we create a new array and place the carry over in first index and then copy the rest of the elements to
    //the new array

    public static int[] increment(int [] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            //update value and return updated array
            if (arr[i] != 9) {
                arr[i] = arr[i] + 1;
                return arr;
            }

            //carry over 1 and make value at index 0
            arr[i] = 0;
        }

        //if we are this far we need to create a new array of size arr.length + 1
        int[] arrN = new int[arr.length + 1];
        arrN[0] = 1;
        for (int i = 1; i < arrN.length; i++) {
            arrN[i] = 0;
        }
        return arrN;
    }


    //o(n) time (we iterate through the entire array up to once, and might need to create/copy all elements
    //to new array. O(1) space, unless we need to copy over.
    public static void main(String[] args) {
        System.out.println("Array 1");
        int[] arr = {2, 4, 5, 2, 1, 4};
        increment(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //code to print
        System.out.println("Array 2");
        int[] arr2 = {2, 4, 5, 2, 1, 9};
        increment(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

        System.out.println("Array 3");
        int[] arr3 = {9, 9, 9, 9, 9, 9};
        arr3 = increment(arr3);
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
    }
}
