package heaps;

/**
 * Created by alexisherrera on 9/14/17.
 */
public class Star {
    int x;
    int y;
    int z;

    public Star(int xC, int yC, int zC) {
        x = xC;
        y = yC;
        z = zC;
    }

    public double distanceToOrigin() {
        //distance formula is sqare root of square of all differences of two objects with coordinates.
        //since we are using the origin we can just square all values and take square root of them
        double distance = Math.sqrt((x*x) + (y*y) + (z*z));
        return distance;
    }
}
