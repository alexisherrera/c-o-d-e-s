package stacks_queues;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by alexisherrera on 9/19/17.
 */
public class P2 {
    //evaluate RPN expressions

    public static int evaluate(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        //evaluate tokens
        for (String s: tokens) {

            if (operators.contains(s)) {
                int a = stack.pop();
                int b = stack.pop();
                int result = 0;

                if (s.equals("+")) {
                    result = b + a;
                }
                else if (s.equals("-")) {
                    result = b - a;
                }
                else if (s.equals("*")) {
                    result = b * a;
                }
                else {
                    result = b / a;
                }

                stack.add(result);
            }
            else {
                stack.push(Integer.parseInt(s));
            }
        }

        //evaluate elements
        return stack.pop();


        //O(n) time, O(n) space
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};


        //should be 6
        System.out.println(evaluate(tokens));
    }
}
