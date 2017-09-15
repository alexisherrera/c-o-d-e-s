package heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by alexisherrera on 9/14/17.
 */
public class P4 {
    //k closest stars problems

    //since we are concerned with finding the k closest stars we can utilize a max heap to store
    //k stars. We use a max heap because we would like to replace the star that is largest of the current
    //k stars and replace it with the element which are handling.

    //we can measure distance by finding the distance from star coordinates to the origin of (0,0,0).
    //we do this by creating a class for star objects


    public static List<Star> kClosestStars(List<Star> stars, int k) {

        //create our max heap that ranks elements by distance to origin.
        //larger distances should be on top. opposite of natural ordering
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, new Comparator<Star>() {
            @Override
            public int compare(Star o1, Star o2) {
                return Double.compare(o1.distanceToOrigin(), o2.distanceToOrigin()) * -1;
            }
        });


        //fill our maxHeap with k elements
        for (int i = 0; i < k; i++) {
            maxHeap.add(stars.get(i));
        }

        //do the steps to find the k closest stars
        for (int i = k; i < stars.size(); i++) {
            double maxDistanceInHeap = maxHeap.peek().distanceToOrigin();
            if (stars.get(i).distanceToOrigin() < maxDistanceInHeap) {
                maxHeap.remove();
                maxHeap.add(stars.get(i));
            }
        }

        //put k closest stars in result list
        List<Star> kStars = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            kStars.add(null);
        }
        int index = k - 1;
        while(!maxHeap.isEmpty()) {
            kStars.set(index, maxHeap.remove());
            index--;
        }


        return kStars;
    }

    public static void main(String[] args) {
        Star s1 = new Star(1,2,4);
        Star s2 = new Star(20,-2,1);
        Star s3 = new Star(4,4,2);
        Star s4 = new Star(1,90,5);
        Star s5 = new Star(80,32,1);
        Star s6 = new Star(-5,2,0);
        Star s7 = new Star(3,3,3);


        List<Star> stars = new ArrayList<>();
        stars.add(s1);
        stars.add(s2);
        stars.add(s3);
        stars.add(s4);
        stars.add(s5);
        stars.add(s6);
        stars.add(s7);

        List<Star> kClosestStars = kClosestStars(stars, 3);

        for (Star s: kClosestStars) {
            System.out.println(s.distanceToOrigin());
        }

    }


}
