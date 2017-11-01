package leetcode;
import java.util.*;

/**
 * Created by alexisherrera on 11/1/17.
 */
public class LRUCache {
    //doubly linked list
    private static class Node {
        Integer val;
        Integer key;
        Node next;
        Node prev;

        public Node(Integer k, Integer v) {
            val = v;
            key = k;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Node front;
    Node end;
    int count = 0;
    int capacity;

    private void addFront(Node n) {
        front.next.prev = n;
        n.next = front.next;
        front.next = n;
        n.prev = front;
    }

    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        front  = new Node(null, null);
        end = new Node(null, null);
        front.next = end;
        end.prev = front;
    }

    public int get(int key) {
        if (!map.containsKey(key)) { return -1; }

        //should never be invalidated when getting. We can retireve value return it
        //and update our list ordering
        Node valN = map.get(key);
        int result = valN.val;
        //move the node to the front
        remove(valN);
        addFront(valN);
        map.put(key, front.next);
        return result;
    }

    public void put(int key, int value) {
        //simply update. cannot violate
        if (map.containsKey(key)) {
            Node val = map.get(key);
            remove(val);
            val.val = value;
            addFront(val);
            map.put(key, val);
        }
        else {
            if (count == capacity) {
                Node update = new Node(key, value);
                map.remove(end.prev.key);
                remove(end.prev);
                addFront(update);
                map.put(key, update);
            }
            else {
                Node update = new Node(key, value);
                count++;
                addFront(update);
                map.put(key, update);
            }
        }
    }
}
