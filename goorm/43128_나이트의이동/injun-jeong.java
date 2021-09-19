package goorm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q43128 {
    private static BufferedReader br;
    private static int L;
    private static List<Position> queue;
    private static int[][] memo;
    private static Position src;
    private static Position dest;

    private static class Position {
        int col, row;

        Position(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }

    public static void main(String[] args) throws Exception {
        /* init instance variable */
        setup();

        /* bfs */
        bfs();

        /* result */
        System.out.println(memo[dest.col][dest.row]);
    }


    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        L = Integer.parseInt(input);
        queue = new ArrayList<>();
        memo = new int[L][L];

        for (int idx = 0; idx < L; idx++) {
            for (int jdx = 0; jdx < L; jdx++) {
                memo[idx][jdx] = -1;
            }
        }

        input = br.readLine();
        String[] inputs = input.split(" ");
        src = new Position(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        memo[src.col][src.row] = 0;

        input = br.readLine();
        inputs = input.split(" ");
        dest = new Position(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
    }


    private static void bfs() {
        queue.add(src);

        Position curr;
        while ( !queue.isEmpty() ) {
             curr = queue.remove(0);

            if ( (curr.col + 2 < L ) && (curr.row - 1 >= 0) ) {
                if ( memo[curr.col + 2][curr.row - 1] == -1
                        || memo[curr.col + 2][curr.row - 1] > memo[curr.col][curr.row] + 1 ) {
                    memo[curr.col + 2][curr.row - 1] = memo[curr.col][curr.row] + 1;
                    queue.add(new Position(curr.col + 2, curr.row - 1));
                }
            }
            if ( (curr.col + 1 < L ) && (curr.row - 2 >= 0) ) {
                if ( memo[curr.col + 1][curr.row - 2] == -1
                        || memo[curr.col + 1][curr.row - 2] > memo[curr.col][curr.row] + 1 ) {
                    memo[curr.col + 1][curr.row - 2] = memo[curr.col][curr.row] + 1;
                    queue.add(new Position(curr.col + 1, curr.row - 2));
                }
            }
            if ( (curr.col - 1 >= 0 ) && (curr.row - 2 >= 0) ) {
                if ( memo[curr.col - 1][curr.row - 2] == -1
                        || memo[curr.col - 1][curr.row - 2] > memo[curr.col][curr.row] + 1 ) {
                    memo[curr.col - 1][curr.row - 2] = memo[curr.col][curr.row] + 1;
                    queue.add(new Position(curr.col - 1, curr.row - 2));
                }
            }
            if ( (curr.col - 2 >= 0 ) && (curr.row - 1 >= 0) ) {
                if ( memo[curr.col - 2][curr.row - 1] == -1
                        || memo[curr.col - 2][curr.row - 1] > memo[curr.col][curr.row] + 1 ) {
                    memo[curr.col - 2][curr.row - 1] = memo[curr.col][curr.row] + 1;
                    queue.add(new Position(curr.col - 2, curr.row - 1));
                }
            }
            if ( (curr.col - 2 >= 0 ) && (curr.row + 1 < L) ) {
                if ( memo[curr.col - 2][curr.row + 1] == -1
                        || memo[curr.col - 2][curr.row + 1] > memo[curr.col][curr.row] + 1 ) {
                    memo[curr.col - 2][curr.row + 1] = memo[curr.col][curr.row] + 1;
                    queue.add(new Position(curr.col - 2, curr.row + 1));
                }
            }
            if ( (curr.col - 1 >= 0 ) && (curr.row + 2 < L) ) {
                if ( memo[curr.col - 1][curr.row + 2] == -1
                        || memo[curr.col - 1][curr.row + 2] > memo[curr.col][curr.row] + 1 ) {
                    memo[curr.col - 1][curr.row + 2] = memo[curr.col][curr.row] + 1;
                    queue.add(new Position(curr.col - 1, curr.row + 2));
                }
            }
            if ( (curr.col + 1 < L ) && (curr.row + 2 < L) ) {
                if ( memo[curr.col + 1][curr.row + 2] == -1
                        || memo[curr.col + 1][curr.row + 2] > memo[curr.col][curr.row] + 1 ) {
                    memo[curr.col + 1][curr.row + 2] = memo[curr.col][curr.row] + 1;
                    queue.add(new Position(curr.col + 1, curr.row + 2));
                }
            }
            if ( (curr.col + 2 < L ) && (curr.row + 1 < L) ) {
                if ( memo[curr.col + 2][curr.row + 1] == -1
                        || memo[curr.col + 2][curr.row + 1] > memo[curr.col][curr.row] + 1 ) {
                    memo[curr.col + 2][curr.row + 1] = memo[curr.col][curr.row] + 1;
                    queue.add(new Position(curr.col + 2, curr.row + 1));
                }
            }
        }
    }
}
