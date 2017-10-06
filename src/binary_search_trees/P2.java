package binary_search_trees;

import binary_trees.tree.TreeNode;

/**
 * Created by alexisherrera on 10/5/17.
 */
public class P2 {

    //find the first key greater than a given a value in a BST
    public static TreeNode firstKeyGreater(TreeNode root, int v) {

        //the approach I will take will involve holding two pointers (kind of like linked list).
        //if the root is less than value iterate right with one pointer.
        //if the root is eq or larger than val --> save that node in a pointer and iterate left with running
        //pointer. keep doing this until our running node is null


        TreeNode running = root;
        TreeNode potentialNode = null;

        while (running != null) {
            //go right
            if (running.data < v) {
                running = running.right;
            }
            //go left and save the value
            else {
                potentialNode = running;
                running = running.left;
            }
        }

        //this is essentially performing binary search, which will take O(h) and O(lgn) in balanced tree
        return potentialNode;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        TreeNode leftS = new TreeNode();
        TreeNode leftSS = new TreeNode();
        TreeNode rightS = new TreeNode();

        tree.data = 79;
        leftS.data = 21;
        rightS.data = 100;
        leftSS.data = 18;
        tree.left = leftS;
        tree.right = rightS;
        leftS.left = leftSS;

        System.out.println(firstKeyGreater(tree, 17).data);
    }
}
