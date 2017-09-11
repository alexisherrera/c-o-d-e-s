package binary_trees;

import binary_trees.tree.TreeNode;

/**
 * Created by alexisherrera on 8/31/17.
 */
public class P2 {

    //test if a binary tree is symmetric
    public static boolean isSymmetric(TreeNode root) {
        //we will do a post order approach in which we check the subtrees to see if they are symmetric.

        //we do this by checking weather the left and right subtrees of our two children aare symmetric

        //because of this we need to compare two trees. Therefore, we define a new function that takes in two trees
        if (root == null) { return true; }
        return areSymmetric(root.left, root.right);

        //take O(n) time because we reach each node once. O(h) space.
    }

    public static boolean areSymmetric(TreeNode r, TreeNode l) {
        if (r == null && l == null) { return true; } //both null thus both symmetric
        if (r == null || l == null) { return false; } //only one null and thhus not symmetric

        //check if subtrees are symmetric
        boolean halfSym = areSymmetric(r.left, l.right);
        boolean halfSym2 = areSymmetric(r.right, l.left);

        if (r.data == l.data && halfSym && halfSym2) { return true; }
        return false;
    }

}
