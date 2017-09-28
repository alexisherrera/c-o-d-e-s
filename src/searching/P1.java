package searching;

/**
 * Created by alexisherrera on 9/26/17.
 */
public class P1 {
    //search a sorted array for the first occurance of k

    public static int firstOccK(int[] nums, int target) {
        //do binary search iteratively
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            //check if we are at the element specified
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) {
                //check if first occurance
                return firstOccKHelper(nums, mid);
            }

            if (nums[mid] > target) {
                hi = mid -1;
            }
            else {
                lo = mid + 1;
            }
        }
        return -1;

        //this approach is actually rather ineffecient. Consider the case when all the elements have value k

        //in this case iterating through all elements takes O(n) time.

        //a better approach is to continue doing binary search until indices overlap and the value
    }

    public static int findFirstOccKBetter(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        //note that in this solution we keep track of a variable result that will return our result at the
        //end search
        int result = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (target == nums[mid]) {
                result = mid;
                hi = mid - 1;
            }

            else if (nums[mid] > target) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
         }
         return result;

        //this solution guarantees a runtime of O(lgN) and a space complexity of O(1).
    }

    //helper to find the first occurance of a value in an arr
    public static int firstOccKHelper(int[] nums, int index) {
        int target = nums[index];
        int i  = index;

        while (i >= 0 && nums[i] == target) {
            i = i - 1;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {-14, -14, - 14, -14, -14, -10, 2, 108, 108, 243, 285, 285, 285, 401};

        //should be 3
        System.out.println(findFirstOccKBetter(nums, 108));
        //should be 6
        System.out.println(findFirstOccKBetter(nums, 285));

        //should be 6
        System.out.println(findFirstOccKBetter(nums, -14));
    }
}
