package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexisherrera on 9/19/17.
 */
public class P17 {

    //soduku checker problem
    public static boolean isDone(char[][] board) {
        //a board is 9x9 and we need to check that all rows contains the numbers 1-9,
        //all cols contain the numbers  1-9
        //each 3x3 grid contains the digits 1-9
        //essentially we need to check that no row, col, or 3x3 grid has duplicates. '.' denote empty spaces

        //check rows
        for (int row = 0; row < board.length; row++) {
            if (!checkRow(board, row)) { return false; }
        }


        //check cols
        for (int col = 0; col < board[0].length; col++) {
            if (!checkCol(board, col)) { return false; }
        }

        //check mini grids
        for (int rowStart = 0; rowStart < board.length; rowStart = rowStart + 3) {
            for (int colStart = 0; colStart < board[0].length; colStart = colStart + 3) {
                if (!checkGrid(board, rowStart, colStart)) { return false; }
            }
        }

        //we check every el board in O(n^2) time and we do it 3 times therefore our time is O(n^2)
        return true;
    }

    //check grid given row start and col start
    public static boolean checkGrid(char[][] board, int rowStart, int colStart) {
        Set<Character> s = new HashSet<>();

        for (int row = rowStart; row < rowStart + 3; row++) {
            for (int col = colStart; col < colStart + 3; col++) {
                if (board[row][col] == '.') { continue; }
                if (isCharValid(board[row][col]) && !s.contains(board[row][col])) {
                    s.add(board[row][col]);
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean checkCol(char[][] board, int col) {
        Set<Character> s = new HashSet<>();

        for (int row = 0; row < board.length; row++) {
            if (board[row][col] == '.') { continue; }
            if (isCharValid(board[row][col]) && !s.contains(board[row][col])) {
                s.add(board[row][col]);
            }
            else {
                return false;
            }
        }
        return true;
    }


    //function to check row
    public static boolean checkRow(char[][] board, int row) {
        Set<Character> s = new HashSet<>();

        //iterate through row by iterating through columns
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == '.') { continue; }
            if (isCharValid(board[row][i]) && !s.contains(board[row][i])) {
                s.add(board[row][i]);
            }
            else {
                return false;
            }
        }
        return true;
    }

    //check if char is valid should be 1-9 or '.'
    public static boolean isCharValid(char c) {
        return (c - '1' >= 0 && c- '1' < 9);
    }
}
