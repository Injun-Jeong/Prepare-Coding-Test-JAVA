package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q054_Spiral_Matrix {
    int m;
    int n;
    int[][] memo;
    List<Integer> answer;
    String[] dir = {"right", "down", "left", "up"};
    int dirIdx;

    class Position {
        int col;
        int row;

        Position(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        /* init instance variable */
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        answer = new ArrayList<>();
        dirIdx = 0;

        /* simulate to get answer */
        getAnswer(matrix);

        return answer;
    }


    private void getAnswer(int[][] matrix) {
        Position pos = new Position(0, 0);
        int cnt = 0;

        while ( cnt < m * n ) {
            memo[pos.col][pos.row] = 1;
            answer.add(matrix[pos.col][pos.row]);
            changePosition(pos);
            cnt++;
        }
    }


    private void changePosition(Position position) {
        if ( shouldChangeDirection(position) ) {
            dirIdx = (dirIdx + 1) % 4;
        }

        if (dir[dirIdx].equals("right")) {
            position.row = position.row + 1;
        } else if (dir[dirIdx].equals("down")) {
            position.col = position.col + 1;
        } else if (dir[dirIdx].equals("left")) {
            position.row = position.row - 1;
        } else if (dir[dirIdx].equals("up")) {
            position.col = position.col - 1;
        }
    }


    private boolean shouldChangeDirection(Position position) {
        if ( dir[dirIdx].equals("right")
                && ( (position.row + 1 == n) || (memo[position.col][position.row + 1] == 1) )
        ) {
            return true;
        }
        if ( dir[dirIdx].equals("down")
                && ( (position.col + 1 == m) || (memo[position.col + 1][position.row] == 1) )
        ) {
            return true;
        }
        if ( dir[dirIdx].equals("left")
                && ( (position.row - 1 == -1) || (memo[position.col][position.row - 1] == 1) )
        ) {
            return true;
        }
        if ( dir[dirIdx].equals("up")
                && ( (position.col - 1 == -1) || (memo[position.col - 1][position.row] == 1) )
        ) {
            return true;
        }

        return false;
    }
}
