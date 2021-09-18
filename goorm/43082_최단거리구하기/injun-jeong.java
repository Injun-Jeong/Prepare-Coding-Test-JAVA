package goorm;

import java.io.*;

public class Q43082 {
    private static BufferedReader br;
    private static int N;
    private static int[][] map;
    private static int[][] memo;
    private static String answer;


    public static void main(String[] args) throws Exception {
        /* init instant value */
        setup();

        /* create map */
        createMap();

        /* get answer */
        memo[0][0] = 1;
        traverse(0, 0);

        /* result */
        printResult();
    }


    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = Integer.parseInt(input);
        map = new int[N][N];
        memo = new int[N][N];
        answer = Integer.toString(Integer.MAX_VALUE);
    }


    private static void createMap() throws IOException {
        for (int idx = 0; idx < N; idx++) {
            String input = br.readLine();
            String[] inputs = input.split(" ");

            for (int jdx = 0; jdx < N; jdx++ ) {
                map[idx][jdx] = Integer.parseInt(inputs[jdx]);
            }
        }
    }


    private static void traverse(int col, int row) {
        if ( (col == N - 1) && (row == N - 1) ) {
            answer = Integer.parseInt(answer) < memo[col][row]
                        ? answer
                        : Integer.toString(memo[col][row]);
            return;
        }

        // right
        if ( (row + 1 < N) && map[col][row + 1] == 1) {
            if ( memo[col][row + 1] == 0
                    || memo[col][row + 1] > memo[col][row] + 1 ) {
                memo[col][row + 1] = memo[col][row] + 1;
                traverse(col, row + 1);
            }
        }
        // left
        if ( (row - 1 >= 0) && map[col][row - 1] == 1) {
            if ( memo[col][row - 1] == 0
                    || memo[col][row - 1] > memo[col][row] + 1 ) {
                memo[col][row - 1] = memo[col][row] + 1;
                traverse(col, row - 1);
            }
        }
        // up
        if ( (col + 1 < N) && map[col + 1][row] == 1) {
            if ( memo[col + 1][row] == 0
                    || memo[col + 1][row] > memo[col][row] + 1 ) {
                memo[col + 1][row] = memo[col][row] + 1;
                traverse(col + 1, row);
            }
        }
        // down
        if ( (col - 1 >= 0) && map[col - 1][row] == 1) {
            if ( memo[col - 1][row] == 0
                    || memo[col - 1][row] > memo[col][row] + 1 ) {
                memo[col - 1][row] = memo[col][row] + 1;
                traverse(col - 1, row);
            }
        }
    }


    private static void printResult() {
        if (answer.equals(Integer.toString(Integer.MAX_VALUE))) {
            return;
        } else {
            System.out.println(answer);
        }
    }
}
