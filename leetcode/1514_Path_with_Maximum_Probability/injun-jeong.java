package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q1514_Path_with_Maximum_Probability {
    private int N;
    private double[] memo;
    private List<List<Node>> adjs;

    private class Node {
        int idx;
        double prob;

        Node(int idx, double prob) {
            this.idx = idx;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        init(n);
        setup(edges, succProb, start);
        dijkstra(start);
        return memo[end] == -1 ? 0 : memo[end];
    }


    private void init(int n) {
        N = n;
        memo = new double[N];
        adjs = new ArrayList<>();

        for (int cnt = 0; cnt < N; cnt++) {
            List<Node> list = new ArrayList<>();
            adjs.add(list);
        }
    }


    private void setup(int[][] edges, double[] succProb, int start) {
        /* memo */
        for (int idx = 0; idx < N; idx++) {
            memo[idx] = -1;
        }
        memo[start] = 1;

        /* adjacent graph */
        for (int idx = 0; idx < edges.length; idx++) {
            Node node1 = new Node(edges[idx][0], succProb[idx]);
            Node node2 = new Node(edges[idx][1], succProb[idx]);

            adjs.get(edges[idx][1]).add(node1);
            adjs.get(edges[idx][0]).add(node2);
        }
    }


    private void dijkstra(int start) {
        int idx;
        List<Node> list;

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            if (memo[n2] - memo[n1] > 0) { return 1; }
            else if (memo[n2] - memo[n1] == 0) { return 0; }
            else { return -1; }
        });
        pq.add(start);

        while ( !pq.isEmpty() ) {
            idx = pq.remove();
            list = adjs.get(idx);

            for (Node node : list) {
                if ( memo[node.idx] <= 0 ) {
                    memo[node.idx] = memo[idx] * node.prob;
                    pq.add(node.idx);
                } else if ( memo[node.idx] < memo[idx] * node.prob ) {
                    memo[node.idx] = memo[idx] * node.prob;
                    pq.add(node.idx);
                }
            }
        }
    }
}
