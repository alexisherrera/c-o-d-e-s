package sorting;

import linkedlists.ListNode;
import linkedlists.P1;

import java.util.List;

/**
 * Created by alexisherrera on 9/12/17.
 */
public class P10 {
    //merge sort on linked lists

    public static ListNode<Integer> mergesort(ListNode<Integer> list) {
        //base cases: if end of list or if we have came down to a single element
        if (list == null || list.next == null) {
            return list;
        }

        ListNode<Integer> slow = list;
        ListNode<Integer> fast = list;
        ListNode<Integer> beforeSlow = null;

        //iterate through the list using a two pointer technique so that when the fast pointer
        //reaches the end of the list, the slow pointer is right in the middle.
        //if list of length odd, we will reach the very last element of the list, if even we will reach null (for fast pointer)
        while (fast != null && fast.next != null) {
            //before slow is just one step before slow
            beforeSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //now that we have gotten the middle of the list, we can cut the list in half by making the L -> before slow
        //one list and slow to the end another list
        beforeSlow.next = null;

        //merge sort on both lists
        ListNode<Integer> halfOne = mergesort(list);
        ListNode<Integer> halfTwo = mergesort(slow);

        return P1.merge(halfOne, halfTwo);
    }


    public static void main(String[] args) {
        ListNode<Integer> n1 = new ListNode<>(100);
        ListNode<Integer> n2 = new ListNode<>(20);
        ListNode<Integer> n3 = new ListNode<>(300);
        ListNode<Integer> n4 = new ListNode<>(-9);
        ListNode<Integer> n5 = new ListNode<>(0);
        ListNode<Integer> n6 = new ListNode<>(-10);
        ListNode<Integer> n7 = new ListNode<>(5);
        ListNode<Integer> n8 = new ListNode<>(100);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        ListNode<Integer> sortedList = mergesort(n1);

        while (sortedList != null) {
            System.out.println(sortedList.d);
            sortedList = sortedList.next;
        }



    }
}
