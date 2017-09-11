package binary_trees.traversals;

import binary_trees.tree.TreeNode;

import java.util.ArrayList;

/**
 * Created by alexisherrera on 8/31/17.
 */
public class preorder {

    //pre order traversal of a tree is when we visit the root node and then the left subtree and then the right
    public static ArrayList<Integer> preorderT(TreeNode root) {
        //in an inorder traversal we traverse left subtree then root the right subtree
        ArrayList<Integer> preorder = new ArrayList<>();
        preorderT(root, preorder);
        return preorder;
    }

    private static void preorderT(TreeNode root, ArrayList<Integer> list) {
        if (root == null) { return; }
        list.add(root.data);
        preorderT(root.left, list);
        preorderT(root.right, list);
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
        ArrayList<Integer> list = preorderT(tree);
        System.out.println(list);
    }
}
