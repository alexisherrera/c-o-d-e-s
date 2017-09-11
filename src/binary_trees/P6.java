package binary_trees;

import binary_trees.tree.TreeNode;

/**
 * Created by alexisherrera on 8/31/17.
 */
public class P6 {

    //find root to leaf path with specified sum

    //we are given a sum and a binary tree and we need to check if there is a root-leaf path that equals given sum

    public static boolean pathWithSumExists(TreeNode root, int sum) {
        return pathWithSumExistsH(root, sum, 0);
    }

    public static boolean pathWithSumExistsH(TreeNode root, int targetSum, int sum) {
        //we will use this helper method to help us traverse the tree in a DFS approach to calculate sums on the go
        if (root == null) { return false; }

        if (root.left == null && root.right == null) {
            return sum + root.data == targetSum;
        }

        return pathWithSumExistsH(root.left, targetSum, sum + root.data) || pathWithSumExistsH(root.right, targetSum, sum + root.data);
    }
}
