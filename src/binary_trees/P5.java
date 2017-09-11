package binary_trees;

import binary_trees.tree.TreeNode;

/**
 * Created by alexisherrera on 8/31/17.
 */
public class P5 {

    //sum the root to leaf paths in a binary tree

    //each node in the tree represents a binary digit. By traversing the tree we get many different binary numbers
    //design an algorithm that computes the sum of all the binary numbers represented by the root-to-leaf orderings

    //approach: my first approach is to use a depth first search approach in which I construct the numbers
    //by reaching the leaves. Once I reach the leaves I convert the binary number into a digit and then add it

    public static int rootToLeafSum(TreeNode root, int sum) {
        if (root == null) {
            //dealt with it in leetcode
        }
        return 0;
    }



}
