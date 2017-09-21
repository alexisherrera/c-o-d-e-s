package dynamic_programming;

/**
 * Created by alexisherrera on 9/21/17.
 */
public class P3 {
    //count the number of ways to traverse a 2D array
    //from top left corner to the bottom right
    public static int traverse(int[][] matrix) {
        return 0;
    }

    //function that will solve this for us using recursion
    public static int traverse(int[][] matrix, int row, int col) {

        //check basecases
        if (row >= matrix.length || col >= matrix[0].length) { return 0; }


        //check if we are at the bottom right
        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            return 1;
        }

        //traverse to the right and down
        else {
            return traverse(matrix, row + 1, col) + traverse(matrix, row, col + 1);
        }
    }



    public static void main(String[] args) {
        int[][] m = new int[5][5];

        System.out.println(traverse(m, 0, 0));
    }
}
