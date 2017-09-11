package binary_trees;

import binary_trees.tree.TreeNodeP;

/**
 * Created by alexisherrera on 8/31/17.
 */
public class P4 {
    //LCA when we have parent nodes

    public static TreeNodeP LCA(TreeNodeP a, TreeNodeP b, TreeNodeP root) {
        //a simple approach is to bubble up the a and b nodes until we reach the root.


        //but how do we do this without jumping over the LCA. A simple approach is to find the depth of
        //the two nodes. with each depth we can level out the iterations needed to bubble up in order to find the
        //root. we level out the depth of the deeper node by bubbling up until they are the same. Then bubble up together
        //until we reach the same node

        int depthA = depth(root, a, 0);
        int depthB = depth(root, b, 0);

        if (depthA == -1 || depthB == -1) { return null; }

        if (depthA == 0) { return a; }
        if (depthB == 0) { return b; }

        //level out
        if (depthA > depthB) {
            a = levelOut(a, depthA - depthB);
        }
        else if (depthB > depthA) {
            b = levelOut(b, depthB - depthA);
        }

        while (a != b) {
            a = a.parent;
            b = b.parent;
        }

        return a;
    }

    public static TreeNodeP levelOut(TreeNodeP node, int amount) {
        for (int i = 0; i < amount; i++) {
            node = node.parent;
        }
        return node;
    }


    public static int depth(TreeNodeP root, TreeNodeP a, int height) {
        if (root == null) { return -1; }
        if (a.data == root.data) { return height; }

        int isInLeft = depth(root.left, a, height + 1);
        if (isInLeft != -1) { return isInLeft; }

        int isInRight = depth(root.right, a, height + 1);
        if (isInRight != -1) { return isInRight; }
        return -1;


    }
}
