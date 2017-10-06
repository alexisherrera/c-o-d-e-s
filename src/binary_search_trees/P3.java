package binary_search_trees;

import binary_trees.tree.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by alexisherrera on 10/6/17.
 */
public class P3 {

    //find the k largest elements in a BST
    public static ArrayList<Integer> kLargerElements(TreeNode root, int k) {
        ArrayList<Integer> results = new ArrayList<>();
        kLargerElements(root, k, results);
        return results;
    }

    //one approach is to do a reverse inorder traversal and place iterms while k is not zero
    public static void kLargerElements(TreeNode root, int k, ArrayList<Integer> results) {

        if (root == null) { return; }

        //search right before left, giving us larger values before smaller values
        kLargerElements(root.right, k, results);

        if (results.size() < k) {
            results.add(root.data);
            kLargerElements(root.left, k, results);
        }
        else { return; }

        //this takes a time complexity of O(n).
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

        System.out.println(kLargerElements(tree, 2));
    }



}
