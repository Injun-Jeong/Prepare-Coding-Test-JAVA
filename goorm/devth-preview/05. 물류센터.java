package goorm.devth;

import java.io.*;

public class Q05 {
    private static BufferedReader br;
    private static int N;
    private static long[][] map;

    public static void main(String[] args) throws Exception {
        setup();
        createMap();
        floydWarshall();
        getAnswer();
    }


    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new long[N][N];

        /* init map */
        for (int idx = 0; idx < N; idx++) {
            for (int jdx = 0; jdx < N; jdx++) {
                if (idx == jdx) {
                    map[idx][jdx] = 0;
                } else {
                    map[idx][jdx] = Long.MAX_VALUE;
                }
            }
        }
    }


    private static void createMap() throws IOException {
        String input;
        String[] inputs;
        int a, b;
        long w;
        for (int cnt = 1; cnt < N; cnt++) {
            input = br.readLine();
            inputs = input.split(" ");

            a = Integer.parseInt(inputs[0]);
            b = Integer.parseInt(inputs[1]);
            w = Long.parseLong(inputs[2]);

            map[a][b] = w;
            map[b][a] = w;
        }
    }


    private static void floydWarshall() {
        for (int k = 0; k < N; k++) {
            for (int src = 0; src < N; src++) {
                for (int dest = 0; dest < N; dest++) {
                    if (map[src][k] == Long.MAX_VALUE || map[k][dest] == Long.MAX_VALUE) {
                        continue;
                    }
                    else if (map[src][k] + map[k][dest] < map[src][dest]) {
                        map[src][dest] = map[src][k] + map[k][dest];
                    }
                }
            }
        }
    }


    private static void getAnswer() {
        long answer = -1;
        long temp;
        for (int idx = 0; idx < N; idx++) {
            temp = 0;
            for (int jdx = 0; jdx < N; jdx++) {
                temp += map[idx][jdx];
            }
            answer = answer == -1 ? temp
                                    : temp < answer ? temp : answer;
        }

        System.out.println(answer);
    }
}
