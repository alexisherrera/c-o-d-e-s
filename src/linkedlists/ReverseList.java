package linkedlists;

/**
 * Created by alexisherrera on 9/9/17.
 */
public class ReverseList {

    static ListNode<Integer> headG;

    //reverse a single sublist

    //will do recursively. take head and recurse until the end of the list. when we reach the end of the list
    //we will return the nodes and change the order of our pointers.
    public static ListNode<Integer> reverse(ListNode<Integer> head) {
        if (head == null) { return null; }
        if (head.next == null) { headG = head; return head; }

        ListNode<Integer> newHead = reverse(head.next);
        //null out the new head to avoid a cycle
        head.next = null;
        //make the next pointer of newhead to equal head
        newHead.next = head;
        return newHead.next;

    }
}
