package binary_trees;
import binary_trees.tree.TreeNode;

/**
 * Created by alexisherrera on 8/31/17.
 */
public class P1 {
    //test if a binary tree is height balanced

    public static boolean isTreeHeightBalanced(TreeNode root) {

        //this take a preorder approach in which we check the root and then the children
        //this is pretty inefficient because we check the height of the left subtree and the right subtree
        //for each node, this means checking O(n) nodes for each node. This gives us a runtime of O(n^2). Not too good.


        //if for each node the difference in the height of the left and right subtrees is at most one

        //i will take a recursive approach in which we will check if the left and right subtrees of a node
        //are different by at most 1.
        if (root == null) { return true; }

        //get height of left and right subtrees
        int lH = height(root.left);
        int rH = height(root.right);

        int hDiff = Math.abs(lH - rH);

        //if the difference is NOT either 0 or 1 then we we break the balanced condition
        if (hDiff != 0 && hDiff != 1) { return false; }
        return isTreeHeightBalanced(root.left) && isTreeHeightBalanced(root.right);
    }


    public static int isBalancedDFS(TreeNode root) {
        //this approach tries to minimize the time complexity by computing the height for each node in a seperate call.
        //this approach calculates the height as we go.

        //we need to figure out whether the height of our children and determine wheather they qualify to be balanced
        if (root == null) { return 0; }
        return 0;
    }


    //o(h) time
    public static int height(TreeNode root) {
        if (root == null) { return -1; }
        return 1 + Math.max(height(root.left),height(root.right));
    }

    public static boolean isHeightBalanced(TreeNode root) {
        //think about how to solve this: to identify that a tree is truly height balanced, we need to find the height
        //of the left subtrees and the height of the right subtrees. They are only balanced if the heigh difference is
        //1 or 0.

        //lets compute the height of the trees as we go down the tree. we return -1 if the heights are balanced or the
        //height of the tree if they are balanced. we can do this in a separate function


        //now that we have made our function to determine height and evaluate height balanced-statefulness,
        //all we need to do is call the function and check if we do retrieve the target error message
        return findHeightAndBalanceState(root) != -1;
    }

    public static int findHeightAndBalanceState(TreeNode root) {
        //no violation in BC --> therefore return the height
        if (root == null) { return 0; }

        //find the heights of left subtrees and right subtrees
        int leftHeight = findHeightAndBalanceState(root.left);
        int rightHeight = findHeightAndBalanceState(root.right);

        //check if they our target indicator. we would like to bubble up our target if not true;
        if (leftHeight == -1 || rightHeight == -1) { return -1; }

        //now assuming our heights are all good. lets check if at this part of the tree the heights are balanced
        if (Math.abs(leftHeight - rightHeight) == 0 || Math.abs(leftHeight - rightHeight) == 1) {
            //bubble up the height at this node
            return Math.max(leftHeight, rightHeight) + 1;
        }
        else {
            return -1;
        }
    }

}
