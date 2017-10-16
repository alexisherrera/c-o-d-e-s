package leetcode;
import java.util.*;
/**
 * Created by alexisherrera on 10/16/17.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        //brute force: remove k digits at all possible spots parse to int and evaluate which is smaller'
        //greedy approach find k consectutive digits that have largest sum and are left most
        char[] s = num.toCharArray();

        int index = 0;
        Stack<Character> stack = new Stack<>();

        while (index < s.length) {

            while (!stack.isEmpty() && stack.peek() > s[index] && k > 0) {
                stack.pop();
                k--;
            }
            //place current element in stack
            stack.push(s[index]);
            index++;
        }

        //suppose all numbers in stack are in sorted order ascending.nothing would have been popped off. Thus, we
        //need to continously pop elements from it.
        while(k>0){
            stack.pop();
            k--;
        }

        //reconstruct string.
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }

        str.reverse();
        int i = 0;
        //remove trailing 0s
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }

        return i == str.length() ? "0" : str.substring(i);

        //because I use string builder the running time is o(n) and space is O(n -k )
    }
}
