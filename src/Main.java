public class Main {

    int carrotsEaten = 0;

    private int[] midPosition(int[][] garden) {
        int[] result = new int[2];

        //true center exists
        if (garden.length % 2 == 1 && garden[0].length % 2 == 1) {
            result[0] = garden.length / 2;
            result[1] = garden [0].length / 2;
        }
        //true center doesn't exist. find largest number near center
        else {
            int rowCenter = garden.length/2 - 1;
            int colCenter = garden[0].length/2 ;
            int[] dirs = new int[] {1, 0, -1 };
            int max = 0;

            for (int i = 0; i < dirs.length; i++) {
                if (dirs[i] == 1) { continue; }
                for (int j = 0; j < dirs.length; j++) {
                    if (rowCenter + i <  garden.length && rowCenter + i >= 0 &&
                            colCenter + j <  garden.length && colCenter + j >= 0 &&
                            max < garden[rowCenter + i][colCenter + j]) {

                        System.out.println((rowCenter + i) + "->"+(colCenter + j));

                        max = garden[rowCenter + i][colCenter + j];
                        result[0] = rowCenter + i;
                        result[1] = colCenter + j;

                    }
                }
            }
        }
        System.out.println("result: " + result[0] + "->" + result[1]);
        return result;
    }

    public int HungryRabit(int[][] garden) {
        //find the position of the rabbit
        int[] mid = midPosition(garden);
        explore(garden, mid[0], mid[1]);
        return carrotsEaten;
    }

    private void explore(int[][] garden, int row, int col) {

        System.out.println("r/c: " + row+ "->"+col+" value:" + garden[row][col]);

        //general case. eat carrots at cell and choose cell with most carrots
        carrotsEaten = carrotsEaten + garden[row][col];
        garden[row][col] = 0;
        int[] next = nextCellToVisit(garden, row, col);
        if (next[0] == -1 && next[1] == -1) { return; }

        explore(garden, next[0], next[1]);
    }

    //find the next cell to visit
    private int[] nextCellToVisit(int[][] garden, int row, int col) {
        int[] result = new int[] { -1, -1 };
        int max = 0;

        //check the cases
        if (row + 1 < garden.length && garden[row + 1][col] > max) {
            max = garden[row + 1][col];
            result[0] = row + 1;
            result[1] = col;
        }
        if (row - 1 >= 0 && garden[row - 1][col] > max) {
            max = garden[row - 1][col];
            result[0] = row - 1;
            result[1] = col;
        }
        if (col + 1 < garden[0].length && garden[row][col + 1] > max) {
            max = garden[row][col + 1];
            result[0] = row;
            result[1] = col + 1;
        }
        if (col - 1 >= 0 && garden[row][col - 1] > max) {
            max = garden[row][col - 1];
            result[0] = row;
            result[1] = col - 1;
        }

        return result;
    }

    public static void main(String[] args) {
	    int[][] test = new int[][] {
                {5, 7, 8, 6, 3},
                {0, 0, 7, 0, 4},
                {4, 6, 3, 4, 9},
                {3, 1, 0, 5, 8}
        };

        Main m = new Main();

        System.out.println(m.HungryRabit(test));
    }
}
