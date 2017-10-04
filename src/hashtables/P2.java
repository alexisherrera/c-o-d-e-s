package hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexisherrera on 9/8/17.
 */
public class P2 {

    //is an anonymous letter constructable

    public static boolean isLetterConstructable(String letter, String mag) {

        //create the map of characters for magazine
        Map<Character, Integer> mapOfMag= new HashMap<>();

        //populate map with character counts in magazine
        for (Character c: mag.toCharArray()) {
            if (mapOfMag.containsKey(c)) {
                mapOfMag.put(c, mapOfMag.get(c) + 1);
            }
            else {
                mapOfMag.put(c, 1);
            }
        }


        //check if there are enough to create letter with it
        for (Character c : letter.toCharArray()) {
            if (!mapOfMag.containsKey(c)) { return false; }
            else {
                int count = mapOfMag.get(c);
                if (count == 1) {
                    mapOfMag.remove(c);
                }
                else {
                    mapOfMag.put(c, count - 1);
                }
            }
        }

        return true;
        //running time of O(max(n, n)). space: O(c).
    }

    public static void main(String[] args) {
        String mag = "i am alex the is herrera, and I approve this messaged";
        String letter = "alexis herrera approved the message";

        //should be true
        System.out.println(isLetterConstructable(letter, mag));

    }
}
