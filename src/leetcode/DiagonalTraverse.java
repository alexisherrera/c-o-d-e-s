package leetcode;
import java.util.*;

/**
 * Created by alexisherrera on 10/15/17.
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) { return new int[0]; }
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[] result = new int[rowCount * colCount];
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        //number of total diagonals will rowCount + colCount - 1

        //rows
        for (int i = 0; i < rowCount; i++) {

            //if we need to collect in reverse order use stack
            int rIndex = i;
            int cIndex = 0;

            while (rIndex >= 0 && cIndex < colCount) {
                //collect upwards
                if (i % 2 == 0) {
                    result[index] = matrix[rIndex][cIndex];
                    index++;
                }
                //use stack
                else {
                    stack.push(matrix[rIndex][cIndex]);
                }
                rIndex = rIndex - 1;
                cIndex = cIndex + 1;
            }

            //add items from stack to result
            if (i % 2 == 1) {
                while (!stack.isEmpty()) {
                    result[index] = stack.pop();
                    index++;
                }
            }
        }

        //columns
        for (int i = 1; i < colCount; i++) {
            int rIndex = rowCount - 1;
            int cIndex = i;

            while (rIndex >= 0 && cIndex < colCount) {
                if ((i + rowCount - 1) % 2 == 0) {
                    result[index] = matrix[rIndex][cIndex];
                    index++;
                }
                else {
                    stack.push(matrix[rIndex][cIndex]);
                }
                rIndex--;
                cIndex++;
            }

            while (!stack.isEmpty()) {
                result[index] = stack.pop();
                index++;
            }
        }
        return result;

        //running time is O(n*M) space is O(m), m is largest diagonal.
    }
}
