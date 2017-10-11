package leetcode;

/**
 * Created by alexisherrera on 10/11/17.
 */
public class BeautifulArrangement {
    int count = 0;
    public int countArrangement(int N) {
        //one approach is to find all the permutations of arrays 1 -- > n if while constructing a permutation one
        //of the conditions fails, we backtrack.
        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        backtrack(nums, 0);
        return count;
    }

    public void backtrack(int[] nums, int index) {
        //basecase == successful arangement
        if (index == nums.length) {
            count++;
        }

        //general case

        //find the permutations
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            //check the two conditions for arrangement
            if (nums[index] % (index + 1) == 0 || (index + 1) % nums[index] == 0) {
                backtrack(nums, index + 1);
            }
            //swap again to maintain relative order of the remaining of the array
            swap(nums, index, i);
        }

        //RT complexity is the number of permutations. Space is O(n) because thats how deep recursive stack gets
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
