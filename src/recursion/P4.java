package recursion;

import java.util.ArrayList;

/**
 * Created by alexisherrera on 9/5/17.
 */
public class P4 {
    public static int count = 0;
    //generate the power set

    //we know that to create a powerset to find the cardinality of the powerset it is 2^n. because we find
    //all the ways in which an element can either be included in a set and the ways in which it can be omitted

    public static void powerset(ArrayList<Integer> set, int index) {

        //we can iterate through the values of the set and recursively compute the powerset by either including
        //the element we are at at iteration or not.

        //basecase, when index == size of set
        if (index == set.size()) {
            System.out.println(set);
            count++;
            return;
        }

        int setSize = set.size();

        //include or omit each element in the set
        for (int i = index; i < setSize; i++) {
            powerset(new ArrayList<Integer>(set), i + 1);
            ArrayList<Integer> updatedList = new ArrayList<Integer>(set);
            updatedList.remove(i);
            powerset(updatedList, i);
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(8);
        powerset(list, 0);
        System.out.println("final count is: " + count);
    }

}
