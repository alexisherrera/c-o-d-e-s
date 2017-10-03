package linkedlists;

/**
 * Created by alexisherrera on 10/2/17.
 */
public class P4 {

    //overlapping lists---cycle free overlapping lists
    public static ListNode<Integer> overlappingLists(ListNode<Integer> a, ListNode<Integer> b) {
        //we first need to compute the length of each list

        if (a == null || b == null) { return null; }

        int distA = 0;
        ListNode<Integer> aIter = a;

        while (aIter.next != null) {
            distA++;
        }

        int distB = 0;
        ListNode<Integer> bIter = b;

        while (bIter.next != null) {
            distB++;
        }

        //check if the two nodes at the end are the same
        if (aIter != bIter) { return null; }

        ListNode<Integer> catchUp = distA >= distB ? a : b;
        int catchUpDist = distA >= distB ? distA : distB;
        ListNode<Integer> other = distA < distB ? a : b;
        int otherDist = distA < distB ? distA : distB;


        //make both distances equal
        while (catchUpDist != otherDist) {
            catchUp = catchUp.next;
            catchUpDist--;
        }


        //iterate together until both pointers point to same node
        while (catchUp != other) {
            catchUp = catchUp.next;
            other = other.next;
        }

        return other;
    }
}
