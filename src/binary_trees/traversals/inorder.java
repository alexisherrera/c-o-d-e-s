package binary_trees.traversals;

import java.util.ArrayList;
import binary_trees.tree.TreeNode;

/**
 * Created by alexisherrera on 8/31/17.
 */
public class inorder {
    public static ArrayList<Integer> inorderT(TreeNode root) {
        //in an inorder traversal we traverse left subtree then root the right subtree
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderT(root, inorder);
        return inorder;
    }

    private static void inorderT(TreeNode root, ArrayList<Integer> list) {
        if (root == null) { return; }
        inorderT(root.left, list);
        list.add(root.data);
        inorderT(root.right, list);
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
        ArrayList<Integer> list = inorderT(tree);
        System.out.println(list);
    }
}
