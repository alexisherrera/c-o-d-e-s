package arrays;

/**
 * Created by alexisherrera on 8/16/17.
 */
public class P1 {

    //dutch national flag problem

    //initial thoughts is to maintain three different lists: one for larger, equal, and larger keys. After
    //placing elements into lists, we put them in the original array. This is O(n) time, but O(n) space.


    //to do this in O(1) space we need to do manipulation within the array. One approach is to iterate through
    //the array three times. In the first pass we take care of placing the smaller items, in the second the equal,
    //and in the third the larger elements. O(n) time, O(1) space.


    public static void DutchFlag(int[] arr, int pivotIndex) {
        int pivotVal = arr[pivotIndex];
        int indexBuilder = 0;

        //first pass is to place smaller items
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < pivotVal) {
                swap(arr, i, indexBuilder);
                indexBuilder++;
            }
        }

        //second pass for equal items
        for (int i = indexBuilder; i < arr.length; i++) {
            if (arr[i] == pivotVal) {
                swap(arr, i, indexBuilder);
                indexBuilder++;
            }
        }

        //no need to do a third pass, they are already larger.

    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //O(n) time ---> more like o(2n), but same. O(1) space.
    public static void main(String[] args) {
        int[] array = { 0,3, 2, 5, 7, 100, -2,5, 29, 4, 92, 5, -9998 , 5 ,90};
        DutchFlag(array, 3);
        //pivot value: 5

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }


    }
}
