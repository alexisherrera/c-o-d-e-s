package binary_trees;

import binary_trees.tree.TreeNode;

/**
 * Created by alexisherrera on 8/31/17.
 */
public class P3 {

    //compute the lowest common ancestor in a binary tree
    public static TreeNode LCABruteForce(TreeNode a, TreeNode b, TreeNode root) {
        //one way we can solve this is by searching for a and b in the root node. if they are on
        //different branches then we are at lowest common ancestor. Searching however takes O(n) time and we
        //may need to do it many times. lets implement it however


        if (root == null) { return null; } //never found it

        //a node can be the LCA of itself
        if (root.data == a.data) {
            return a;
        }
        if (root.data == b.data) {
            return b;
        }

        //look for node in left subtree
        boolean existsOnLeftA = exists(a, root.left);
        boolean existsOnLeftB = exists(b, root.left);

        //are on the same side keep searching for LCA
        if ((existsOnLeftA && existsOnLeftB) || (!existsOnLeftA && !existsOnLeftB)) {
            if (existsOnLeftA) {
                return LCABruteForce(a, b, root.left);
            }
            else {
                return LCABruteForce(a, b, root.right);
            }
        }

        //they are on different sides and therefore this is the LCA
        return root;



        //this algorithm runs in O(n^2) in the worst case. Not very efficient. Consider tree that is skewed. checks
        //n-1 nodes at first then n-2 then n-3 then n-4. This gives summation of order n^2.
    }

    //another approach can be using a pre order traversal. we visit sub trees first. if it is in there we then
    //check if it is in the other then we return true;


    public static TreeNode LCABetter(TreeNode a, TreeNode b, TreeNode root) {
        if (root == null) { return null; }
        if (root == a) { return root; }
        if (root == b) { return root; }

        TreeNode leftSearch = LCABetter(a, b, root.left);

        //if null then not in the subtree
        if (leftSearch == null) {
            return LCABetter(a, b, root.right);
        }

        TreeNode rightSearch = LCABetter(a, b, root.right);
        if (leftSearch!= null && rightSearch != null) { return root; }
        else {
            return leftSearch;
        }

        //this algorithm does not need to check if we cover a particular node at a node. It does this whilst
        //determining weather the node we are at is the LCA. It does this by

        //runs in O(n) time as it is post order traversal. we check subtrees before root. space is o(h) for same reason
    }



    //runs in O(n) time
    public static boolean exists(TreeNode a, TreeNode root) {
        if (root == null) { return false; }
        if (root.data == a.data) { return true; }
        return exists(a, root.left) || exists(a, root.right);
    }


}
