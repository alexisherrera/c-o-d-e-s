package hashtables;

import java.util.HashMap;

/**
 * Created by alexisherrera on 9/8/17.
 */
public class P2 {
    //is an anonymous letter constructable


    //i will iterate through the letter first and fill up a hashmap consisting of characters in the letters and
    //their frequency. after doing this i will iterate through the magazine and subtract the frequency
    //from map for each letter in the magazine if the freq is greater than 0. At the end of the mag, if
    //our hashmap has all keys with freq 0, then it is constructable.

    public static boolean isLetterConstructable(String letter, String mag) {
        if (letter == null || mag == null) { return false; }
        if (letter.length() == 0) { return true; }
        if (letter.length() > mag.length()) { return false; }

        HashMap<Character, Integer> map = new HashMap<>();

        //iterate through letter and populate the map
        for (char c : letter.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }
        }


        //iterate through magazine until our map is empty
        for (char c : mag.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);

                if (map.get(c) == 0) {
                    map.remove(c);
                    if (map.isEmpty()) { return true; }
                }
            }
        }

        return false;
    }
}
