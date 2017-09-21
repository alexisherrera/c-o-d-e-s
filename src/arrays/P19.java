package arrays;

/**
 * Created by alexisherrera on 9/20/17.
 */
public class P19 {
    //rotate a 2D array 90 degrees clockwise

    public static void rotate(int[][] matrix) {
        //we will use an offset approach where we will offset a max of n/2 times (doesnt matter if length is odd)

        //at each iteration we will swap elements in the top row with elements in the top row
        //with elements in right col with elements in bottom row and elements in left col.
        //this constitutes a full 90 degrees rotation
        //we will do this for each n-1 elements per row

        int endOfArr = matrix.length - 1;

        for (int offset = 0; offset < (matrix.length / 2); offset++) {

            //iterate through rows/cols
            for (int i = offset; i < matrix.length - 1 - offset; i++) {


                //save element on rightmost col
                int temp1 = matrix[i][endOfArr - offset];

                //move top row from i --> end ofArr- (offset)
                matrix[i][endOfArr - offset] = matrix[offset][i];

                //move saved element to the bottom row
                //but save that element first
                int temp2 = matrix[endOfArr - offset][endOfArr - i];

                matrix[endOfArr - offset][endOfArr - i] = temp1;


                //move temp2 to leftmost col
                temp1 = matrix[endOfArr - i][offset];
                matrix[endOfArr - i][offset] = temp2;

                //move temp1 to the top row
                matrix[offset][i] = temp1;
            }

        }
        //O(n^2) running time
    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 4},
                {6, 9, 20},
                {-3, 800, 0}
        };
        rotate(m);


        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col <m[0].length; col++) {
                System.out.print(m[row][col] + " ");
            }
            System.out.println();
        }
    }
}
