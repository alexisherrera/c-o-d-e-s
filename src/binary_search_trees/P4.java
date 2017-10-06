package binary_search_trees;

import binary_trees.tree.TreeNode;

/**
 * Created by alexisherrera on 10/6/17.
 */
public class P4 {
    //compute the LCA in a BST with distinct elements. Will solve recursively

    //look at the root elements value. if the two nodes have values on distinct sides, this is the LCA

    public static TreeNode LCA (TreeNode root, TreeNode a, TreeNode b) {
        if (a == null || b == null) { return null; }
        if (root == null) { return null; }
        if (root == a || root == b) { return root; }

        //check if a and b are on opposite sides. if so this is the LCA
        if ((root.data < b.data && root.data > a.data) || (root.data > b.data && root.data < a.data)) {
            return root;
        }

        //search right side and left side
        TreeNode left = LCA(root.left, a, b);

        if (left == null) {
            return LCA(root.right, a, b);
        }
        return left;

        //in the worst case this program runs in O(n) time, LCA doesnt exist (both a and b smaller than smallest node
        //in tree). Space is O(h) for recursive depth
    }
}
