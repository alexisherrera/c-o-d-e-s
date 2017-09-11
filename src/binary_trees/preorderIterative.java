package binary_trees;

import binary_trees.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by alexisherrera on 9/6/17.
 */
public class preorderIterative {
    public static List<Integer> preorderIterative(TreeNode root) {
        //will utilize a stack to mimic the recursvie stack
        //to recap preorder is when we visit root node before the children subtrees
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            //process current node first
            list.add(curr.data);

            //put left and right subtrees in the stack non-null
            if (curr.left != null) { stack.push(curr.left); }
            if (curr.right != null) { stack.push(curr.right); }

            //make current node element at top of the stack.
            if (stack.isEmpty()) { break; }
            curr = stack.pop();
        }

        return list;
    }
}
