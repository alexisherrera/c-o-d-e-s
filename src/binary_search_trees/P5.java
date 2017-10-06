package binary_search_trees;

import binary_trees.tree.TreeNode;
import binary_trees.traversals.inorder;

/**
 * Created by alexisherrera on 10/6/17.
 */
public class P5 {
    //suppose we are given inorder, preorder, and a postorder sequence of a BST with duplicate elements.
    //can we reconstruct the trees with solely this order?


    //inorder: We cannot! think about the trees with inorder seq: 1,2
    //it is either   2   OR  1
    //              /         \
    //             1            2
    //With more nodes the different sequences increase.
    //Therefore, we conclude that a BST cannot be constructed from an inorder sequence


    //preorder
    //can we reconstruct the trees with solely this order?
    //So we know that the first element in a preorder traversal is a the root node of a tree.
    //The next element corresponds to its child. We can determine whether it is a left or a right child by
    //comparing the value to the root.

    //we can do this process recusively, by creating a node for the index which we are at in a BST.
    //then we recursively create its left child by comparing the subsequent values..

    public static TreeNode buildBSTFromPreorder(int[] preorder, int index, int end) {

        if (index > end || index >= preorder.length || end == -1) { return null; }


        //partition into 3 parts: root, left subtree, and right subtree. Solve recursively
        //left subtree should be less than the left subtree
        //right subtree should be greater than the right subtree

        //root partition
        TreeNode root = new TreeNode();
        root.data = preorder[index];


        //left subtree partition
        //find the last index of last element that is smaller than root
        int lastIndexSmaller = -1;
        for (int i = index + 1; i <= end; i++) {
            if (preorder[i] < root.data) {
                lastIndexSmaller = i;
            }
        }

        //if lastIndex is -1 then there are no elements smaller and we can just null out the left subtree
        //left subtree lies in index + 1 ---> lastIndexSmaller. if lastIndexSmaller = -1, then it is null


        //right subtree partition

        if (lastIndexSmaller == -1) {
            root.left = null;
            root.right = buildBSTFromPreorder(preorder, index + 1, end);
        }
        else {
            root.left = buildBSTFromPreorder(preorder, index + 1, lastIndexSmaller);
            root.right = buildBSTFromPreorder(preorder, lastIndexSmaller + 1, end);
        }

        return root;

        //the complexity of this algorithm is O(n^2). Consider a Tree that is skewed right. we search through n elements
        //at each iteration n - 1, n - 2, n - 3, n -4 ... O(n^2)
    }

    public static void main(String[] args) {
        int[] preorder = {43, 23, 37, 29, 31, 41, 47};

        TreeNode root = buildBSTFromPreorder(preorder, 0, preorder.length - 1);

        System.out.println(inorder.inorderT(root));
    }

}
