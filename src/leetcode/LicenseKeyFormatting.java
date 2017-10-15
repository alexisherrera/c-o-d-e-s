package leetcode;

/**
 * Created by alexisherrera on 10/15/17.
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {

        //start from the back and build the string
        StringBuilder sb = new StringBuilder();
        int count = K;
        char[] s = S.toCharArray();
        int index = S.length() - 1;

        while (index >= 0) {
            if (s[index] == '-') { index--; continue; }
            if (count == 0) {
                sb.append('-');
                count = K;
                continue;
            }

            //get the last character
            char c = s[index];

            //update c if not numeric and lowercase
            if (!Character.isDigit(c) && Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            }

            sb.append(c);
            index--;
            count--;
        }

        sb.reverse();
        return new String(sb);
        //O(n) time and O(1) space (if not including string builder)
    }
}
