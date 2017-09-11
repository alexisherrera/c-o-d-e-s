package recursion;

import java.util.Stack;

/**
 * Created by alexisherrera on 9/5/17.
 */
public class P1 {
    //towers of hanoi problem
    //we are concerned with moving elements from one tower to another


    //set up will create three stacks and fill them up with integers
    public static Stack<Integer>[] setUp() {
        //only one stack needs elements. Lets add 10.
        Stack<Integer> home = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> dest = new Stack<>();

        for (int i = 9; i >= 0; i--) {
            home.add(i);
        }

        Stack<Integer>[] stacks = (Stack<Integer>[]) new Stack[3];
        stacks[0] = home;
        stacks[1] = temp;
        stacks[2] = dest;
        return stacks;
    }


    public static void towers(int n, Stack<Integer> home, Stack<Integer> temp, Stack<Integer> dest) {
        //base case: if no elements in home we are done.
        if (n > 0) {
            System.out.println("this is the level: " + n);
            //move from home to temporary
            towers(n-1, home, dest, temp);

            //move nth element from home to dest
            dest.add(home.pop());
            //move back from temp to dest
            towers(n - 1, temp, home, dest);
        }

    }

    public static void main(String[] args) {
        Stack<Integer>[] towerStacks = setUp();
        towers(10, towerStacks[0], towerStacks[1], towerStacks[2]);

        //print stacks
        System.out.println("Stack one: ");
        System.out.println(towerStacks[0]);
        System.out.println("Stack two: ");
        System.out.println(towerStacks[1]);
        System.out.println("Stack three: ");
        int size = towerStacks[2].size();
        for (int i = 0; i < size; i++) {
            System.out.print(towerStacks[2].pop() + " ");
        }

    }
}
