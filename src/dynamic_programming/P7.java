package dynamic_programming;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexisherrera on 9/26/17.
 */
public class P7 {
    //bed bath and beyond problem

    //we are given a set of words and a string.
    //we need to check if the concatenation of those strings yeilds the given string
    public static String concatPossibleBF(Set<String> set, String s) {
        //first brute force is to concat all of the strings in the set into a long word and check equality
        //we can do this with a list. A set cannot be order
        String result = "";

        for (String str: set) {
            result = result + str;
        }

        System.out.println(result);

        if (result.equals(s)) { return s; }
        else return null;

        //HERE WE face a limitation. Sets are not ordered necessarily. Therefore, this will not work. There is
        //no guarantee that the result string will result into the perfect concat of string s. Therefore, we
        //could be returning null when the concat of all strings in set is valid. Therefore this approach is wrong
    }

    public static String concatPossibleREC(Set<String> set, String s, int index) {
        //one approach to take is to check prefixes. we check if a prefix exists in the set and then we remove it from
        //the set. But then again, we cannot iterate from character to character. Instead we need to "build"
        //our prefixes until we get a match with the set or when run out.
        return null;
    }
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a"); set.add("man"); set.add("a"); set.add("plan"); set.add("a"); set.add("canal");
        String targetS = "amanaplanacanal";

        System.out.println(concatPossibleBF(set, targetS));

    }
}
