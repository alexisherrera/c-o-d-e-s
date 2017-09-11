package sorting;

import sorting.data_structures.Event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by alexisherrera on 9/11/17.
 */
public class P5 {

    private static class Endpoint implements Comparable<Endpoint> {
        int pointVal;
        boolean isStartPoint;

        public Endpoint(int pointV, boolean isStartP) {
            pointVal = pointV;
            this.isStartPoint = isStartP;
        }

        //implement compareTo function for the comparable interface. we want ascending order
        //so we will make
        public int compareTo(Endpoint other) {
            if (other.pointVal < this.pointVal) { return 1; }
            if (other.pointVal > this.pointVal) { return -1; }
            if (other.pointVal == this.pointVal && this.isStartPoint && !other.isStartPoint) {
                return -1;
            }
            else {
                return 0;
            }
        }

    }

    //render a calendar
    //write a program that takes a set of events and determines the maximum number of events that
    //take place concurrently

    public static int maxConcurrentEvents(List<Event> events) {

        //approach: each event has a start and an end. we are interested in seeing how many events' starts/end
        //are within another events starts/ends

        //we can sort by start date and then for each element in the list we can check all other elements in the
        //list if there end dates are less than the element we are on's end date.
        //O(nlgn) + O(n^2) = O(n^2)



        //we can optimize this by creating a sorting of startPoints and endPoints in ascending order by their
        //value. Start points should come before end points if they are equal.
        //Doing this allows us to keep track of how many events are stacked upon each other simply by iterating
        //through the sorted array. We keep a count of how many start events there are at any index in the array.
        //we do this by using an integer variable where we add 1 if we encounter a start element, and decrement
        //by 1 if we encounter an ending element. The maximum value of this variable is the maximum number of events
        //that are overlapped. This works because it keeps track of starting elements that occur before an ending
        //element, but doesn't really tell us where the events start and where they end


        //for this we need to create endPoint arrays, so we can use an inner class
        ArrayList<Endpoint> endpoints = new ArrayList<>();
        for (Event e: events) {
            endpoints.add(new Endpoint(e.start, true));
            endpoints.add(new Endpoint(e.end, false));
        }

        //we will sort this list
        Collections.sort(endpoints);

        int c = 0;
        int maxC = 0;

        for (Endpoint e: endpoints) {
            if (e.isStartPoint) { c++;}
            else {
                c--;
            }
            maxC = Math.max(c, maxC);
        }

        return maxC;

        //this algorithm takes O(nlgn) for the sort and O(N) for iteration. Assuming quicksort, then O(1) space for sort,
        //but O(n) space for the endpoints created and their storage in the array, thus O(n)
    }



    public static void main(String[] args) {
        //test
        Event e1 = new Event(1, 5);
        Event e2 = new Event(2, 7);
        Event e3 = new Event(4, 5);
        Event e4 = new Event(6, 10);
        Event e5 = new Event(8, 9);
        Event e6 = new Event(9, 17);
        Event e7 = new Event(11, 13);
        Event e8 = new Event(12, 15);
        Event e9 = new Event(14, 15);
        Event e10 = new Event(8, 11);

        List<Event> events = new ArrayList<>();
        events.add(e1);
        events.add(e2);
        events.add(e3);
        events.add(e4);
        events.add(e5);
        events.add(e6);
        events.add(e7);
        events.add(e8);
        events.add(e9);
        events.add(e10);


        System.out.println(maxConcurrentEvents(events));


    }
}
