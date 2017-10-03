package linkedlists;

/**
 * Created by alexisherrera on 10/3/17.
 */
public class P10 {
    //even odd merge
    //group even nodes together and then link odd nodes together
    public static ListNode<Integer> evenOddMerge(ListNode<Integer> head) {
        //approach build two lists from the beginning of the ll. save a reference to the first node of the second list.

        if (head == null) { return null; }

        //merge at the end
        ListNode<Integer> evenList = head;

        ListNode<Integer> oddList  = head.next;
        ListNode<Integer> oddHead = head.next;

        while (oddList != null) {
            evenList.next = oddList.next;
            evenList = oddList;
            oddList = oddList.next;
        }

        //merge two lists together
        evenList.next = oddHead;
        return head;

        //takes O(n) time O(1) space

    }

    public static void main(String[] args) {
        ListNode<Integer> l1 = new ListNode<>(0);
        ListNode<Integer> l2 = new ListNode<>(1);
        ListNode<Integer> l3 = new ListNode<>(2);
        ListNode<Integer> l4 = new ListNode<>(3);
        ListNode<Integer> l5 = new ListNode<>(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;


        ListNode<Integer> evenOdd = evenOddMerge(l1);

        //should be 0,2,4,1,3,null
        while (evenOdd != null) {
            System.out.print(evenOdd.d + " -- ");
            evenOdd = evenOdd.next;
        }
    }
}
