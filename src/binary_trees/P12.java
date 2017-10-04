package binary_trees;

import binary_trees.tree.TreeNode;

/**
 * Created by alexisherrera on 10/3/17.
 */
public class P12 {
    //construct a binary tree from traversal data
    //given a preorder traversal and inorder traversal recreate the BT

    public TreeNode createFromPreOrder(int[] preorder, int[] inorder) {
        //will solve this recursively by finding the root of each tree and appending it to the other by traversing
        //the preorder array in order and searching for an element in the inorder traversal


        return helper(preorder, inorder, 0, 0, inorder.length - 1);

    }

    public TreeNode helper(int[] preorder, int[] inorder, int preorderIndex, int inorderS, int inorderE) {

        //base case: we need to stop when the prorder index is larger than preorder, and when
        //in orderS is no longer before inorderE
        if (preorderIndex == preorder.length) { return null; }
        if (inorderS > inorderE) { return null; }

        //general case: search for element at the index of the preorder in the inorder array. partition
        //the array from before the target element and after the target element in the inorder element
        int target = preorder[preorderIndex];
        int targetIndex = -1;

        for (int i = inorderS; i <= inorderE; i++) {
            if (inorder[i] == target) { targetIndex = i; break; }
        }

        TreeNode root = new TreeNode();
        root.data = target;

        //now that we have the target of the root. we can partition the inorder array into two pieces.
        //partition 1: start --> targetIndex - 1.
        //partition 2: targetIndex + 1 --> end
        //for the left side of the tree we do a recursive call to the next index in the preorder sequence
        root.left = helper(preorder, inorder, preorderIndex + 1, inorderS, targetIndex - 1);

        //for the right partition we need to skip all the preorder elements that correspond to the left side of the
        //binary tree that is rooted at this level of recursion. our preorderIndex is currently at our target
        //element for current root. We want to skip all elements from start to target. This is done by finding
        //the distance targetIndex - start + 1

        //we

        int skipForPreorder = (targetIndex - inorderS) + 1;
        root.right = helper(preorder, inorder, preorderIndex + skipForPreorder, targetIndex + 1, inorderE);

        return root;
    }
}
