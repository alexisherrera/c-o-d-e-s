package linkedlists;

/**
 * Created by alexisherrera on 9/9/17.
 */
public class P2 {
    //reverse a linked list sublist from index i to index j.

    public static void reverseSublist(ListNode<Integer> list, int i, int j) {
        int distance = j - i;

        //iterate to start
        for (int k = 1; k < i; k++) {
            list = list.next;
        }

        //list is the element at i
        //we are going to keep track have 3 nodes in which the first will be the left most part of the list.
        //the second will be the element we are trying to reverse. and the third will be right most part of the list;
        //we will point the second node to the first part. thwn update every element by one

    }
}
