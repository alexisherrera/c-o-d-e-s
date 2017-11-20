package leetcode;

import linkedlists.ListNode;

import java.util.List;

/**
 * Created by alexisherrera on 11/17/17.
 */
public class ReverseLinkedList {

    public ListNode reverse (ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
        }

        return curr;
    }
}
