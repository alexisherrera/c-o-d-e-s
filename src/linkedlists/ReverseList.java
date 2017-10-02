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


    public static ListNode<Integer> reverseIter(ListNode<Integer> head) {
        ListNode<Integer> prev = null;
        ListNode<Integer> curr = head;
        ListNode<Integer> next = head.next;

        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        curr.next = prev;

        return curr;

    }

    public static void main(String[] args) {
        ListNode<Integer> l1 = new ListNode<>(1);
        ListNode<Integer> l2 = new ListNode<>(2);
        ListNode<Integer> l3 = new ListNode<>(3);
        ListNode<Integer> l4 = new ListNode<>(4);
        ListNode<Integer> l5 = new ListNode<>(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;


        ListNode<Integer> reversed = reverseIter(l1);

        while (reversed != null) {
            System.out.print(reversed.d + " - ");
            reversed = reversed.next;
        }
    }
}
