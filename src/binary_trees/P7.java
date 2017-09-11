package binary_trees;
import binary_trees.tree.TreeNode;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by alexisherrera on 8/31/17.
 */
public class P7 {

    //implement an inorder traversal without recursion

    //in an inorder traversal we first traverse the left subtree then the root then the right subtree. to
    //do this without recursion we can use a stack to keep all of the nodes in order of their level. For instance
    //we know that the root element will be at the top of the stack. after this, we can add the left node to the stack.
    //when we are done processing the node at the top of the stack, we can add its right child to the stack (and add all of
    //its left children to the stack.

    public static List<Integer> inorderNoRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) { return list; }
        Stack<TreeNode> stack = new Stack<>();

        //Algorithm: we are going to go as far down left in our tree until we reach a null node. While doing this
        //we will be pushing the root nodes we encounter into our stack. when we reach a null node we will retrieve
        //the top element from the stack and then we will make this our current node. we will conitnue the same cycle
        //until our current node is null


        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {

            //go left most and put in our stack
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            //curr is null so we will retrieve a node from our stack.
            curr = stack.pop();
            list.add(curr.data);
            curr = curr.right;
        }
        return list;
    }



    public static void main(String[] args) {

    }
}
