package leetcode;
import java.util.*;

/**
 * Created by alexisherrera on 10/16/17.
 */
public class DecodeString {
    public String decodeString(String s) {
        return helper(s.toCharArray());

    }

    public String helper(char[] s) {
        String result = "";
        Stack<Integer> counts = new Stack<>();
        Stack<String>  subRes = new Stack<>();
        int index = 0;

        //iterate through the char array
        while (index < s.length) {

            //check if it is a number
            if (Character.isDigit(s[index])) {
                String c = "";

                while (index < s.length && Character.isDigit(s[index])) {
                    c = c + s[index];
                    index++;
                }

                //put count in the counts stack
                counts.push(Integer.parseInt(c));
            }

            //if opening parenthesis start placing everything in subRes stack
            else if (s[index] == '[') {
                index++;
                //put sub in our response stack
                subRes.push(result);
                result = "";
            }

            //at the end of a parenthesis
            else if (s[index] == ']') {
                int numTimes = counts.pop();
                String temp = subRes.pop();
                for (int i = 0; i < numTimes; i++) {
                    temp = temp + result;
                }
                result = temp;
                index++;
            }

            //just lingering characters
            else {
                result = result + s[index];
                index++;
            }
        }
        //o(n) time complexity O(n) space
        return result;
    }
}
