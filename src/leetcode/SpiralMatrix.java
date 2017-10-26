package leetcode;
import java.util.*;

/**
 * Created by alexisherrera on 10/26/17.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) { return result; }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;



        while (true) {

            //top row. left --> right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            if (top > bottom) { break; }

            //right col. top --> bottom
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            if (right < left) { break; }

            //bottom row. right --> left
            for (int col = right; col >= left; col--) {
                result.add(matrix[bottom][col]);
            }
            bottom--;
            if (top > bottom) { break; }

            //left col. bottom --> top
            for (int row = bottom; row >= top; row--) {
                result.add(matrix[row][left]);
            }
            left++;
            if (left > right) { break; }
        }
        return result;
    }
}
