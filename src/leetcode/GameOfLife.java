package leetcode;

/**
 * Created by alexisherrera on 11/11/17.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        //brute force: iterate through board in copy 2D arr and follow rules, time is O(mn), but space is O(nm)
        //better? tag the state of the board in accordance to the transitioning mechanism
        //4 possible states:
        //0 --> 0. dead to dead. 0
        //1 --> 1. alive to alive. 1
        //1 --> 0. alive to dead. 2
        //0 --> 1. dead to alive. 3

        //IMPORTANT THING is that original states need to be maintained. In other words, 0 needs to rep dead and 1 needs to
        //rep alive to be able to traverse through elements not yet visited.

        //O(mn) time and O(1) space. DROPBOX INTERVIEW TODAY

        //with this we can mark the board using these states
        int[][] dirs = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                int aliveNeighbors = 0;
                for (int[] d : dirs) {
                    int iUpdate = d[0];
                    int jUpdate = d[1];
                    if (i + iUpdate >= board.length || i + iUpdate < 0 || j + jUpdate >= board[0].length ||
                            j + jUpdate < 0) continue;
                    if (board[i + iUpdate][j + jUpdate] == 1 || board[i + iUpdate][j + jUpdate] == 2) aliveNeighbors++;
                }

                if (board[i][j] == 1 && (aliveNeighbors == 2 || aliveNeighbors == 3)) board[i][j] = 1;
                else if (board[i][j] == 0 && aliveNeighbors == 3) board[i][j] = 3;
                else if (board[i][j] == 1 && aliveNeighbors < 2) board[i][j] = 2;
                else if (board[i][j] == 1 && aliveNeighbors > 3) board[i][j] = 2;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1 || board[i][j] == 3) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }
}
