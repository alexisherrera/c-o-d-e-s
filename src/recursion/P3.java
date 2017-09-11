package recursion;

/**
 * Created by alexisherrera on 9/5/17.
 */
public class P3 {
    public static int count = 0;
    //generate all permutations

    public static void permute(int[] arr) {

    }

    public static void permuteH(int[] arr, int start) {
        //base case
        if (start > arr.length - 1) {
            //print array
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
            count++;
            return;
        }

        //for each element in the array we will consider the case in which any other element is in the start index
        //then build upon each array recursively
        for (int i = start; i < arr.length; i++) {
            //swap character
            swap(arr, start, i);
            permuteH(arr, start + 1);
            swap(arr, start, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] a = { 3, 2, 1, 9};
        permuteH(a, 0);
        System.out.println("count is: " + count);
    }
}
