package binary_trees;

import binary_trees.tree.TreeNode;

import java.util.ArrayList;

/**
 * Created by alexisherrera on 8/31/17.
 */
public class P5 {

    //sum the root to leaf paths in a binary tree

    //each node in the tree represents a binary digit. By traversing the tree we get many different binary numbers
    //design an algorithm that computes the sum of all the binary numbers represented by the root-to-leaf orderings

    //approach: my first approach is to use a depth first search approach in which I construct the numbers
    //by reaching the leaves. Once I reach the leaves I convert the binary number into a digit and then add it

    public static void rootToLeafSum(TreeNode root, ArrayList<String> nums, String num) {


        //we gotta check leaves because they will go on to two basecases (one for each subtree).
        if (root.left == null && root.right == null) {
            num = num + root.data;
            nums.add(num);
            return;
        }

        num = num + root.data;
        rootToLeafSum(root.left, nums, num);
        rootToLeafSum(root.right, nums, num);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        TreeNode leftS = new TreeNode();
        TreeNode rightS = new TreeNode();

        tree.data = 79;
        leftS.data = 21;
        rightS.data = 100;
        tree.left = leftS;
        tree.right = rightS;
        ArrayList<String> list = new ArrayList<>();
        rootToLeafSum(tree, list, "");


        System.out.println(list);
    }




}
