package leetcode;

import java.util.PriorityQueue;

public class Q973_K_Closest_Points_to_Origin {
    private int[][] answer;
    private PriorityQueue<Point> pq;

    private class Point {
        int x, y;
        double dist;

        Point (int x, int y, double dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }


    public int[][] kClosest(int[][] points, int k) {
        setup(points, k);
        getAnswer();
        return answer;
    }


    private void setup(int[][] points, int k) {
        answer = new int[k][2];
        pq = new PriorityQueue<>((p1, p2) -> {
            if ( p1.dist - p2.dist > 0 ) { return 1; }
            else if ( p1.dist - p2.dist == 0 ) { return 0; }
            else { return -1; }
        });

        int x, y;
        for (int[] point : points) {
            x = point[0];
            y = point[1];
            pq.add(new Point(x, y, Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2) )));
        }
    }


    private void getAnswer() {
        Point point;
        for (int idx = 0; idx < answer.length; idx++) {
            point = pq.remove();
            answer[idx][0] = point.x;
            answer[idx][1] = point.y;
        }
    }
}
