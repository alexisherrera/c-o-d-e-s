package binary_trees;

import binary_trees.tree.TreeNode;

import java.util.ArrayList;

/**
 * Created by alexisherrera on 10/4/17.
 */
public class P13 {

    static int index = 0;

    //reconstruct a binary tree from a preorder traversal with markers

    public static TreeNode reconstruct(ArrayList<Integer> preorder) {
        index = 0;
        return helper(preorder);
    }

    public static TreeNode helper(ArrayList<Integer> preorder) {
        //the general apporach is that we will use recursion to incremement the index of the preorder list.
        //doing this will increment our index through recursion. We will stop recursing when we reach a null node.

        //once we reach null node we will begin with our right subtree.

        Integer rootVal = preorder.get(index);
        index++;

        if (rootVal == null) { return null; }

        TreeNode root = new TreeNode();
        root.data = rootVal;


        //this order is absolutely critical because the preorder accounts for left elements before right elements
        //therefore, our index will only correspond to right subtree elements once we are finished processing all
        //left subtree elements. Namely, this is acheived when reach leaves (return null; )
        root.left = helper(preorder);
        root.right = helper(preorder);

        return root;

        //time complexity is O(n) --> we traverse each node once. The space is O(h).
    }
}
