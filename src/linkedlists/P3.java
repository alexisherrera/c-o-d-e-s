package linkedlists;


/**
 * Created by alexisherrera on 10/2/17.
 */
public class P3 {
    //test for cyclicity

    //write a program that returns null if there is not a cycle. if there is return the start of the cycle.

    public static ListNode<Integer> testCyclicity(ListNode<Integer> head) {
        //approach. Use the two node. if they intercept there is a cycle. if they do not intersect then there is
        //no cycle.

        if (head == null) { return null; }
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;

        while ((fast.next != null && fast != null)) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) { break; }
        }

        if (fast == null || fast.next == null ) { return null; }

        //find the beginning of the loop by moving the first node to the head
        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

        //algorithm takes O(n) to find cycle. Then it takes O(non-cyclic part) to find beginning which is
        //O(n)

        //the reason it works to move one pointer to the beginning of a list is that:
        //it takes M + p*l + k steps for slow pointer to meet with fast pointer.
        //similarly it takes M + q*l + k steps for fast pointer to meet slow pointer. This
        //ends up being 2(slowSteps) = fastSteps.

        //by simplication we end up with M+K = (q-2p)*l. This means that M+K is a multiple of the length of
        //the list ((q-2p) is an integer) AKA the factor. Thus, we only need to advance the pointer in the loop
        //by M steps (because it is already offset by K steps). M is nothing but the distance from the beginning
        //of the LL till the loop. THerefore when we move one pointer to the beginning of the list and it equals
        //other node, we have reached the beginning of the cycle.
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
        l5.next = l2;

        ListNode<Integer> testCyclicity = testCyclicity(l1);

        if (testCyclicity ==null) {
            System.out.println("null");
        }
        else {
            System.out.println(testCyclicity.d);
        }
    }
}
