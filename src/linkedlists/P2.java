package linkedlists;

/**
 * Created by alexisherrera on 9/9/17.
 */
public class P2 {
    //reverse a linked list sublist from index i to index j. numbering of the nodes begins at one

    public static ListNode<Integer> reverseSublist(ListNode<Integer> list, int i, int j) {
        ListNode<Integer> beforeSublistHead = list;
        int count = 1;

        //traverse up until the value prior to the start of the sublist
        while (count < i - 1) {
            beforeSublistHead = beforeSublistHead.next;
            count++;
        }


        //at this point we have a pointer to the node before the beginning of the sublist.
        //from here we can begin our reversal process which consists of inserting nodes in between our
        //beforeSublistHead node and the current head of our sublist
        ListNode<Integer> sublistHead = beforeSublistHead.next;
        count++;

        while (count < j) {
            //find the node that is next to be used as the new head of our reversed sublist
            ListNode<Integer> aheadNode = sublistHead.next;
            //save the next iterations sublist head
            sublistHead.next = aheadNode.next;


            aheadNode.next = sublistHead;
            //connect the node that is before the sublist to new head
            beforeSublistHead.next = aheadNode;
            //connect the new head to the old sublist head


            //we want to do this until we reach the end of the sublist
            count++;
        }
        return list;
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

        reverseSublist(l1, 2, 3);

        while(l1 != null) {
            System.out.print(l1.d + " - ");
            l1= l1.next;
        }

    }
}
