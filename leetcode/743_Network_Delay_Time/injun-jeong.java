package leetcode;

public class Q743_Network_Delay_Time {
    private int N, K;
    private int[][] map;

    public int networkDelayTime(int[][] times, int n, int k) {
        setup(n, k);
        createMap(times);
        floydWarshall();
        int answer = getAnswer();
        return answer;
    }


    private void setup(int n, int k) {
        N = n;
        K = k - 1;
        map = new int[N][N];

        /* init map */
        for (int idx = 0; idx < N; idx++) {
            for (int jdx = 0; jdx < N; jdx++) {
                if (idx == jdx) {
                    map[idx][jdx] = 0;
                } else {
                    map[idx][jdx] = Integer.MAX_VALUE;
                }
            }
        }
    }


    private void createMap(int[][] times) {
        for (int[] time : times) {
            map[time[0] - 1][time[1] -1] = time[2];
        }
    }


    private void floydWarshall() {
        for (int m = 0; m < N; m++) {
            for (int src = 0; src < N; src++) {
                for (int dest = 0; dest < N; dest++) {
                    if ( map[src][m] == Integer.MAX_VALUE || map[m][dest] == Integer.MAX_VALUE ) {
                        continue;
                    } else if (map[src][m] + map[m][dest] < map[src][dest]) {
                        map[src][dest] = map[src][m] + map[m][dest];
                    }
                }
            }
        }
    }


    private int getAnswer() {
        int answer = -1;

        for (int idx = 0; idx < N; idx++) {
            if ( map[K][idx] == Integer.MAX_VALUE ) {
                return -1;
            } else {
                answer = answer == -1 ? map[K][idx]
                                        : map[K][idx] > answer ? map[K][idx] : answer;
            }
        }

        return answer;
    }
}
