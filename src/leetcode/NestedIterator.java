package leetcode;

import java.util.Iterator;

/**
 * Created by alexisherrera on 10/10/17.
 */
//public class NestedIterator implements Iterator<Integer> {
//    ArrayList<Integer> list;
//    int globalCount = 0;
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        list = new ArrayList<>();
//        createList(0, nestedList);
//    }
//
//    private void createList(int index, List<NestedInteger> l) {
//        //base case
//        if (index >= l.size()) {
//            return;
//        }
//
//        NestedInteger el = l.get(index);
//        //add to list
//        if (el.isInteger()) {
//            list.add(el.getInteger());
//        }
//        //another list
//        else {
//            List<NestedInteger> otherList = el.getList();
//            createList(0, otherList);
//        }
//        createList(index + 1, l);
//    }
//
//    @Override
//    public Integer next() {
//        Integer element = list.get(globalCount);
//        globalCount++;
//        return element;
//    }
//
//    @Override
//    public boolean hasNext() {
//        if (globalCount < list.size()) { return true; }
//        return false;
//    }
//}