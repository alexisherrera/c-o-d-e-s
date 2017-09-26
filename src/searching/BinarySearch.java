package searching;

/**
 * Created by alexisherrera on 9/26/17.
 */
public class BinarySearch {
    //implementation of binary search
    public static int binarySearch(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }


    public static int binarySearch(int[] nums, int target, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) { return mid; }
            //search the left
            if (nums[mid] > target) {
                return binarySearch(nums, target, start, mid - 1);
            }
            //search the right
            return binarySearch(nums, target, mid + 1, end);
        }
        return -1;
    }


    //iterative version. Will typically be more effective (no recursive stack used).
    public static int binarySearchI(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) { return mid; }
            //search left
            else if (nums[mid] > target) {
                //reduce problem in half by making the end mid - 1
                end = mid - 1;
            }
            else {
                //search right. make start mid + 1
                start = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 9, 19, 89, 900, 2900};

        //should both be 6
        System.out.println(binarySearch(nums, 900));
        System.out.println(binarySearchI(nums, 900));
        System.out.println("-----");

        //should both be 7
        System.out.println(binarySearch(nums, 2900));
        System.out.println(binarySearchI(nums, 2900));
        System.out.println("-----");
        //should both be 0
        System.out.println(binarySearch(nums, 1));
        System.out.println(binarySearchI(nums, 1));
        System.out.println("-----");
        //should both be 1
        System.out.println(binarySearch(nums, 4));
        System.out.println(binarySearchI(nums, 4));

    }
}
