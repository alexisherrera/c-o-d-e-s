package binary_search_trees;

import binary_trees.tree.TreeNode;

/**
 * Created by alexisherrera on 10/5/17.
 */
public class P1 {

    static Integer prevValue = null;


    //test if a binary tree satisfies the BST property
    public static boolean isBST(TreeNode root) {
        //one approach to do this is to realize that no node in the left subtree can be larger than the value in
        //the root. Similarly, no node can be smaller than the value of the root in the left subtree,

        //this approach creates an upper and lower bound on the acceptable value of a particular node.
        //initially we have a range of -infinity to +infinity. As we move left, our range is from -infinity
        //to root.val; As we move right, our range is from root.val to +infinity. We traverse the tree recursively

        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //will only work if keys are fall within min and max value ranges
    public static boolean isBST(TreeNode root, int leftLimit, int rightLimit) {
        if (root == null) { return true; }

        //check if violate condition
        if (root.data < leftLimit) { return false; }
        if (root.data > rightLimit) { return false; }

        //search remainder of tree with updated limits
        return isBST(root.left, leftLimit, root.data) && isBST(root.right, root.data, rightLimit);
    }


    //one way to solve this problem without any ranges that may not always prove to be right is to
    //do an inorder traversal and check that nodes are in ascending order
    public static boolean isBSTInorder(TreeNode root) {
        if (root == null) { return true; }
        boolean leftSide = isBSTInorder(root.left);
        if (prevValue != null && prevValue >= root.data) {
            return false;
        }
        prevValue = root.data;
        return leftSide && isBST(root.right);

        //both ways take O(n) time
    }


    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        TreeNode leftS = new TreeNode();
        TreeNode rightS = new TreeNode();

        tree.data = 81;
        leftS.data = 109;
        rightS.data = 82;
        tree.left = leftS;
        tree.right = rightS;

        //should be true
        System.out.println(isBSTInorder(tree));
    }

}
