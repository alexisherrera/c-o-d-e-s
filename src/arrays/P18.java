package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by alexisherrera on 9/19/17.
 */
public class P18 {

    //class for objects that create an index
    private static class Index {
        int row;
        int col;

        public Index(int r, int c) {
            row = r;
            col = c;
        }
    }


    //compute the spiral ordering of a 2D array with dimensions nxn
    public static List<Integer> spiralOrdering(int[][] matrix) {
        //we can iterate through the top row, rightmost col, bottom row, and leftmost col

        //if we think about it, there are n/2 spirals if n is odd then there is one eleme


        //we can have indices at each corner of the 2D matrix and use those as our "limits" of iteration

        Index leftTop = new Index(0, 0);
        Index leftBottom = new Index(matrix.length - 1, 0);
        Index rightTop =  new Index (0, matrix[0].length - 1);
        Index rightBottom = new Index(matrix.length - 1, matrix[0].length - 1);

        List<Integer> result = new ArrayList<>();



        //we will iterate while these values do not overlap each other. we will iterate
        //arr from top row, right col, bottom row, left col. bring the indices towards center (diagonal step)



        while (leftTop.row <= rightTop.row && leftBottom.row <= rightBottom.row) {
            //iterate from left to right: top row
            for (int col = leftTop.col; col < rightTop.col; col++) {
                result.add(matrix[leftTop.row][col]);
            }

            //right col
            for (int row = rightTop.row; row < rightBottom.row; row++) {
                result.add(matrix[row][rightBottom.col]);
            }

            //bottom row
            for (int col = rightBottom.col; col > leftBottom.col; col--) {
                result.add(matrix[leftBottom.row][col]);
            }

            //left col
            for (int row = leftBottom.row; row > leftTop.row; row--) {
                result.add(matrix[row][leftBottom.col]);
            }

            //update the indices diagonally
            leftTop.row = leftTop.row + 1;
            leftTop.col = leftTop.col + 1;

            rightTop.row = rightTop.row + 1;
            rightTop.col--;

            leftBottom.col++;
            leftBottom.row--;

            rightBottom.col--;
            rightBottom.row--;
        }

        //if matrix is odd we need the middle element
        if (matrix.length % 2 == 1) {
            result.add(matrix[rightBottom.row][rightBottom.col]);
        }


        return result;

    }



    public static List<Integer> spiral(int[][] matrix) {
        //another way to approach this problem is by using index offsets to our advantage. We know that each
        //time we compute the spiral ordering of a layer, we can peel that layer off and go to the next inner level

        //we can model this with an offset that is equal at all parts. More so, we know that the offset will only go
        //as far as matrix.length / 2. and ceil(matrix.length/2) if odd (offset indices .

        int offSetLimit = matrix.length % 2 == 1 ? (matrix.length /2) + 1 : matrix.length;
        List<Integer> result = new ArrayList<>();

        for (int offset = 0; offset < offSetLimit; offset++) {
            computeSpiralWithOffset(matrix, offset, result);
        }
        return result;
        //runs in O(n^2) time.
    }

    //helper function to compute spiral with the offset
    public static void computeSpiralWithOffset(int[][] matrix, int offset, List<Integer> result) {

        //will only happen if we have an odd-length matrix. In this case we want the middle eleement;
        if (offset == matrix.length - 1 - offset) {
            result.add(matrix[offset][offset]);
            return;
        }


        //we will focus on getting the n-1 elements per row to keep grabbing all elements in a uniform fashion
        int rightColLimit = matrix[0].length - offset - 1;


        //iterate through top row by iterating from beggining offset -> rightColLimit
        for (int col = offset; col < rightColLimit; col++) {
            result.add(matrix[offset][col]);
        }


        //collect right most col by iterating from offset row to bottomLimit
        int bottomRightLimit = matrix.length - offset - 1;
        for (int row = offset; row < bottomRightLimit; row++) {
            result.add(matrix[row][matrix.length - 1 - offset]);
        }

        //collect the bottom row n-1 elements in reverse order
        for (int col = matrix[0].length - 1 - offset; col > offset; col--) {
            result.add(matrix[matrix.length - 1 - offset][col]);
        }


        //collect the leftmost col n-1 elements in rever
        for (int row = matrix.length - 1; row > offset; row--) {
            result.add(matrix[row][offset]);
        }

    }


    public static void main(String[] args) {
        int[][] m = {
                    {1, 2, 4},
                    {6, 9, 20},
                    {-3, 800, 0}
                    };


        //should be 1,2,4,20,0,800, -3, 6, 9
        System.out.println(spiral(m));

    }




}
