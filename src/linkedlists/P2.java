package linkedlists;

/**
 * Created by alexisherrera on 9/9/17.
 */
public class P2 {
    //reverse a linked list sublist from index i to index j. numbering of the nodes begins at one

    public static ListNode<Integer> reverseSublist(ListNode<Integer> list, int i, int j) {
        ListNode<Integer> dummy = new ListNode<>(-1);
        dummy.next = list;
        //important concept! use a dummy node before a list when needing a prev pointer that is one step behind
        //OG pointer

        ListNode<Integer> beforeSublistHead = dummy;
        int count = 1;

        //traverse up until the value prior to the start of the sublist
        while (count < i) {
            beforeSublistHead = beforeSublistHead.next;
            count++;
        }
        //at this point we have a pointer to the node before the beginning of the sublist.
        //from here we can begin our reversal process which consists of inserting nodes in between our
        //beforeSublistHead node and the current head of our sublist
        ListNode<Integer> sublistHead = beforeSublistHead.next;

        while (count < j) {
            ListNode<Integer> aheadNode = sublistHead.next;
            sublistHead.next = aheadNode.next;
            aheadNode.next = beforeSublistHead.next;
            beforeSublistHead.next = aheadNode;
            count++;

        }

        return dummy.next;
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

        ListNode<Integer> newList = reverseSublist(l1, 2, 5);

        while(newList != null) {
            System.out.print(newList.d + " - ");
            newList= newList.next;
        }

    }
}
