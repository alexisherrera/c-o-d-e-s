package leetcode;
import java.util.*;

/**
 * Created by alexisherrera on 10/16/17.
 */
public class RandomizedSet {
    Map<Integer, Integer> map;
    ArrayList<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) { return false; }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) { return false; }
        int index = map.get(val);
        if (index != list.size() - 1) {
            Collections.swap(list, index, list.size() - 1);
            map.remove(val);
            map.put(list.get(index), index);
            list.remove(list.size() - 1);
        }
        //if last item simply remove from map and end of list
        else {
            map.remove(val);
            list.remove(list.size() - 1);
        }
        return true;
    }


    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
