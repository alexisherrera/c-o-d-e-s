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
        int leftChild = isBalancedDFS(root.left);
        int rightChild = isBalancedDFS(root.right);
        if (leftChild == -1 || rightChild == -1) { return -1; }

        int hDiff = Math.abs(leftChild - rightChild);
        if (hDiff != -1 && hDiff != 0) { return 1 + Math.max(leftChild, rightChild); }
        return -1;
    }


    //o(h) time
    public static int height(TreeNode root) {
        if (root == null) { return -1; }
        return 1 + Math.max(height(root.left),height(root.right));
    }

    //this will take

}
