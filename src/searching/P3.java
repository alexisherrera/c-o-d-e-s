package searching;

/**
 * Created by alexisherrera on 9/27/17.
 */
public class P3 {
    //search a cyclically sorted array. find the smallest element in a cyclically sorted array in O(nlgn) time

    public static int smallestInCyclicArr(int[] nums) {
        //first thought is to use binary search or some variation of it. we can assume that all elements are distinct

        //we check the first element and the last element and the mid. if the first element is smaller than the
        //mid then the left half is sorted we should make our right the value at the left

        //we then proceed to find out in

        int lo =  0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            if (lo == hi) { return lo; }

            int mid = (lo + hi) / 2;
            System.out.println("mid: " + mid);

            //search right side
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            }
            //search left
            else if (nums[mid] < nums[hi]) {

                //note how we do not decrement the hi by one. We do this just incase we are at the smallest element.
                //we dont wanna eliminate it. This insures however that our program will stop once lo and hi equal each
                //other.
                hi = mid;
            }
        }

        //takes O(lgn) time
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {378, 478, 550, 631, 103, 203, 220, 234, 279, 368};

        //should be 4
        System.out.println(smallestInCyclicArr(nums));
    }
}
