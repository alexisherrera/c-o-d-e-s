package linkedlists;

import java.util.List;

/**
 * Created by alexisherrera on 9/9/17.
 */
public class P1 {


    //merge two sorted singly linked lists into a sorted linked list


    //approach: I will take the two given lists and check the first element. depending on which contains
    //the smaller element, I will append the larger element to the next of the smaller.
    //i will pass the sorted list as an argument and recursively merge the two lists into the sorted list
    //and
    public static ListNode<Integer> merge(ListNode<Integer> node1, ListNode<Integer> node2) {
        if (node1 == null && node2 == null) { return null; }
        if (node1 == null) { return node2; }
        if (node2 == null) { return node1; }

        //find the smaller element
        ListNode<Integer> smaller = node1.d <= node2.d ? node1 : node2;
        ListNode<Integer> larger = node1.d > node2.d ? node1 : node2;

        smaller.next = merge(smaller.next, larger);
        return smaller;
    }


    public static void main(String[] args) {

    }


}
