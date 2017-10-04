package hashtables;

import binary_trees.tree.TreeNodeP;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexisherrera on 9/8/17.
 */
public class P4 {
    //compute the LCA optimizing for close ancestors

    public static TreeNodeP LCASpaceTradeoff(TreeNodeP a, TreeNodeP b) {

        //we will use a as our node that will place all its visited nodes in its set
        Set<TreeNodeP> visited = new HashSet<>();

        while (a != null && b != null) {
            if (a == b) { return b; }
            else if (visited.contains(b)) {
                return b;
            }
            else {
                visited.add(a);
                a = a.parent;
                b = b.parent;
            }
        }

        //continue iterating b if it is not done yet
        while (b != null) {
            if (visited.contains(b)) { return b; }
            b = b.parent;
        }

        //different BT
        return null;

        //running time is O(max(a, b)) a,b are heights.
        //space is O(a-height).
    }
}
