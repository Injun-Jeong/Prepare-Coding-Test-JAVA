package leetcode;

import java.util.ArrayList;
import java.util.List;

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
        List<Node> list = adjs.get(start);
        for (Node node : list) {
            if ( memo[node.idx] <= 0 ) {
                memo[node.idx] = memo[start] * node.prob;
                dijkstra(node.idx);
            } else if ( memo[node.idx] < memo[start] * node.prob ) {
                memo[node.idx] = memo[start] * node.prob;
                dijkstra(node.idx);
            }
        }
    }
}
