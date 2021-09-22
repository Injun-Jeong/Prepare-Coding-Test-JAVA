package goorm;

import java.io.*;

public class Q100980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt((br.readLine()));
        int k = Integer.parseInt(br.readLine());

        String xs = br.readLine();
        String[] splitxs = xs.split(" ");
        int X[] = new int[k];
        for (int i = 0; i < k; i++) {
            X[i] = Integer.parseInt(splitxs[i]);
        }

        String ys = br.readLine();
        String[] splitys = ys.split(" ");
        int Y[] = new int[k];
        for (int i = 0; i < k; i++) {
            Y[i] = Integer.parseInt(splitys[i]);
        }


        /* logic start line */
        System.out.println(solution(n, k, X, Y));
        /* logic end line */
    }

    private static int N, K, answer;
    private static int[][] map;

    public static int solution(int n, int k, int[] X, int[] Y) {
        setup(n, k, X, Y);
        backtracking(0);

        return answer;
    }

    private static void setup(int n, int k, int[] X, int[] Y) {
        N = n;
        K = k;
        answer = 0;
        map = new int[N][N];

        for (int idx = 0; idx < K; idx++) {
            map[Y[idx] - 1][X[idx] - 1] = -1;
        }
    }

    private static void backtracking(int idx) {
        if (idx == N) {
            answer++;
            return;
        }

        for (int jdx = 0; jdx < N; jdx++) {
            if (isOk(idx, jdx)) {
                map[idx][jdx] = 1;
                backtracking(idx + 1);
                map[idx][jdx] = 0;
            }
        }
    }

    private static boolean isOk(int i, int j) {
        if (map[i][j] == -1) {
            return false;
        }

        /* 세로 점검 */
        for (int idx = 0; idx < i; idx++) {
            if (map[idx][j] == 1) {
                return false;
            }
        }

        /* 대각선 점검 */
        for (int cnt = 1; true; cnt++) {
            if (i - cnt >= 0) {
                if (j - cnt >= 0) {
                    if (map[i - cnt][j - cnt] == 1) {
                        return false;
                    }
                }
                if (j + cnt < N) {
                    if (map[i - cnt][j + cnt] == 1) {
                        return false;
                    }
                }
            } else {
                break;
            }
        }

        return true;
    }
}
