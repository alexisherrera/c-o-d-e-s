package binary_trees.traversals;

import binary_trees.tree.TreeNode;

import java.util.ArrayList;

/**
 * Created by alexisherrera on 8/31/17.
 */
public class postorder {

    //a post order traversal is when we visit subtrees before we visit root nodes.
    //pre order traversal of a tree is when we visit the root node and then the left subtree and then the right
    public static ArrayList<Integer> postorderT(TreeNode root) {
        //in an inorder traversal we traverse left subtree then root the right subtree
        ArrayList<Integer> postorder = new ArrayList<>();
        postorderT(root, postorder);
        return postorder;
    }

    private static void postorderT(TreeNode root, ArrayList<Integer> list) {
        if (root == null) { return; }
        postorderT(root.left, list);
        postorderT(root.right, list);
        list.add(root.data);
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
        ArrayList<Integer> list = postorderT(tree);
        System.out.println(list);
    }
}
