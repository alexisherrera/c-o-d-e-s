package linkedlists;

/**
 * Created by alexisherrera on 10/2/17.
 */
public class P7 {
    //remove the kth last element from a list

    public static ListNode<Integer> kthLast(ListNode<Integer> head, int k) {
        //one approach is to have one pointer ahead by k steps and then when so that when we
        //iterate there is a jump of k elements. in doing this when the last element is null we have reached the
        //kth last element


        ListNode<Integer> dummy = new ListNode<>(-1);
        //AGAIN THE DUMMY VARIABLE IT IS IMPORTANT TO NORMALIZE OPERATIONS AND DISREGARD PESKY EDGE CASES
        //(I.E. ONE NODE).
        dummy.next = head;
        ListNode<Integer> slow = dummy;
        ListNode<Integer> kAhead = head;

        for (int i = 0; i < k; i++) {
            kAhead = kAhead.next;
        }

        //move kAhead until it is null. At this point the slow variable will be one place before the node we want to
        //delete. making it perfect for deletion. Note that since we started with a dummy variable, we will always
        //be able to delete, even if it is the first element.
        while (kAhead != null) {
            kAhead = kAhead.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
