package binary_trees;

import binary_trees.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexisherrera on 10/4/17.
 */
public class GetLeaves {

    //program to get all the leaves of a binary tree from left to right
    public static List<Integer> getleaves(TreeNode root) {
        //approach: do DFS on the tree recursing on the left side of the current node (to get left most first).
        //do with helper
        List<Integer> leaves = new ArrayList<>();
        helper(root, leaves);
        return leaves;
    }

    //DP[i] = dP[i- j][i  + 1]
    public static void helper(TreeNode root, List<Integer> leaves) {
        if (root == null) { return; }
        //if leaf save it
        if (root.left == null && root.right == null) {
            leaves.add(root.data);
            return;
        }

        //recurse left first then right
        helper(root.left, leaves);
        helper(root.right, leaves);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        TreeNode leftS = new TreeNode();
        TreeNode rightS = new TreeNode();

        tree.data = 79;
        leftS.data = 21;
        rightS.data = 100;
        tree.left = leftS;
        tree.right = rightS;

        List<Integer> leaves = getleaves(tree);

        System.out.println(leaves);
    }
}
