package dynamic_programming;

/**
 * Created by alexisherrera on 9/21/17.
 */
public class P5 {

    //find if a sequence exists in a 2D array
    public static boolean searchSequence(int[][] matrix, int[] seq) {
        //the technique is to iterate through all values in the matrix. if the seq starts at a seq[1] do bfs

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == seq[0] && search(matrix, seq, 0, row, col)) { return true; }
            }
        }
        return false;
    }



    public static boolean search(int[][] matrix, int[] seq, int index, int row, int col) {
        if (index >= seq.length) { return true; }

        //error checking
        if (row < 0 || col < 0 || row >= matrix.length || col > matrix[0].length) {
            return false;
        }

        if (matrix[row][col] != seq[index]) { return false; }

        //check for every adjacent element
        boolean left = search(matrix, seq, index + 1, row, col - 1);
        boolean up = search(matrix, seq, index + 1, row - 1, col);
        boolean right = search(matrix, seq, index + 1, row, col + 1);
        boolean bottom = search(matrix, seq, index + 1, row + 1, col);

        return (left || up || right || bottom);
    }


}
