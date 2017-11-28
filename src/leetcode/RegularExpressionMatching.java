package leetcode;

/**
 * Created by alexisherrera on 11/1/17.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {

        //base case
        if (p.length() == 0) { return s.length() == 0; }

        //general case

        //are first characters the same
        boolean sameFirst = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        //check for a star
        if (p.length() >= 2 && p.charAt(1) == '*') {
            //check that first characters match and continue using the same front character.
            //also check if we can match by skipping wildcard and all characters before. update
            return (sameFirst && isMatch(s.substring(1), p) ||
                    isMatch(s, p.substring(2)));
        }
        //regexp matching
        else if (sameFirst) {
            return isMatch(s.substring(1), p.substring(1));
        }
        return false;
    }
}
