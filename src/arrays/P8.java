package arrays;

/**
 * Created by alexisherrera on 8/28/17.
 */
public class P8 {

    //compute an alteration

    //approach: I think that we can sort and then weave first half with second half of the array. O(nlgn);
    //without sorting we can iterate and find median in O(n) time and then use 2 hashsets to get all elements greater
    //than median and elements smaller. then place elements in alternating fashion

    //the optimal approach is to do it locally. start at index 0 and work your way up to the end - 1.
    //if index i is even then num[i] must be less than num[i+1]. if not then swap. If i is odd, then num[i]
    //must be greater than num[i + 1], if not then swap. This wont break as we iterate because we only need to concerned
    //with three elements and their ordering which is el[0] < el[1] > el[2]. After this for el[3], we just need it to be
    //larger than el[2]. if it is not then we swap el[2] with el[3]. this doesnt break the orderings for indices 0,1,2 because
    //el[2] would still be smaller than el[1] (b.c. it is smaller than el[3]).

    public static void alteration(int[] nums) {


        for (int i = 0; i < nums.length - 1; i++) {
            //index even and element @ index is larger than index at next odd
            if ((i % 2 == 0) && nums[i] > nums[i + 1]) {
                swap(nums, i , i + 1);
            }
            //index odd and element @ index is smaller than index at next even
            else if ((i % 2 == 1) && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 2, 199, 92, -2, 4, 2, 0, 100, 20};
        alteration(nums);

        for (int i = 0; i < nums.length; i++) {
            String t = "";
            if (i % 2 == 0) { t = "even"; }
            else { t = "odd"; }
            System.out.print(t+ ": " + nums[i] + " ");
        }

    }



}
