package goorm;

import java.io.*;
import java.lang.*;
import java.util.*;

/* 오후 7시 ~ 오후 7시 20분 */
public class Q88520 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void testCase(int caseIndex) {
        int N = scanner.nextInt();  // 지도의 크기
        int K = scanner.nextInt();  // 놀이공원의 크기

        int[][] wastes = new int[N][N]; // 각 칸의 쓰레기 존재 여부
        for (int r = 0; r < N; r += 1) {
            for (int c = 0; c < N; c += 1) {
                wastes[r][c] = scanner.nextInt();
            }
        }


        /* logic start line */
        int answer = getAnswer(N, K, wastes);
        /* logic end line */


        System.out.println(answer);
    }

    static class Field {
        int colStart;
        int colEnd;
        int rowStart;
        int rowEnd;

        Field(int colStart, int colEnd, int rowStart, int rowEnd) {
            this.colStart = colStart;
            this.colEnd = colEnd;
            this.rowStart = rowStart;
            this.rowEnd = rowEnd;
        }
    }

    private static int getAnswer(int N, int K, int[][] wastes) {
        int answer = Integer.MAX_VALUE;
        int waste;
        Field field;

        for ( int colStart = 0; colStart <= (N - K) ; colStart++ ) {
            for ( int rowStart = 0; rowStart <= (N - K) ; rowStart++ ) {
                field = new Field(colStart, colStart + (K - 1), rowStart, rowStart + (K - 1));

                waste = checkField(field, wastes);
                answer = waste < answer ? waste : answer;
            }
        }

        return answer;
    }


    private static int checkField(Field field, int[][] wastes) {
        int waste = 0;
        for (int col = field.colStart; col <= field.colEnd; col++) {
            for (int row = field.rowStart; row <= field.rowEnd; row++) {
                waste = wastes[col][row] == 1 ? waste + 1 : waste;
            }
        }
        return waste;
    }


    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }

    }

}
