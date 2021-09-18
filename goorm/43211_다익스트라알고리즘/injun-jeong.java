package goorm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q43211 {
    private static BufferedReader br;
    private static int N, E;
    private static ArrayList<List<Node>> graph;
    private static Distance[] dists;
    private static int initIdx;


    static class Node {
        int idx, weight;
        Node next, prev;

        Node(int idx, int weight, Node next, Node prev) {
            this.idx = idx;
            this.weight = weight;
            this.next = next;
            this.prev = prev;
        }
    }


    static class Distance {
        int dist;
        Node node;

        Distance(int dist, Node node) {
            this.dist = dist;
            this.node = node;
        }
    }


    public static void main(String[] args) throws Exception {
        /* init instant data */
        setup();

        /* create graph */
        createGraph();

        /* create edges */
        createEdge();

        /* get the min distance for each node */
        Node startNode = new Node(initIdx, 0, null, null);
        dijkstra(graph.get(initIdx), startNode);

        /* result */
        printResult();
    }


    private static void setup() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");
        N = Integer.parseInt(inputs[0]);
        E = Integer.parseInt(inputs[1]);
        dists = new Distance[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            Distance dist = new Distance(Integer.MAX_VALUE, null);
            dists[idx] = dist;
        }
    }


    private static void createGraph() {
        graph = new ArrayList<>();

        for (int idx = 0; idx <= N; idx++) {
            List<Node> nodes = new ArrayList<>();
            graph.add(nodes);
        }
    }


    private static void createEdge() throws IOException {
        for (int cnt = 0; cnt < E; cnt++) {
            /* input data */
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int idxStart = Integer.parseInt(inputs[0]);
            int idxEnd = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);

            /* create node */
            Node node1 = new Node(idxStart, weight, null, null);
            Node node2 = new Node(idxEnd, weight, null, null);

            /* create edge */
            graph.get(idxStart).add(node2);
            graph.get(idxEnd).add(node1);
        }

        String input = br.readLine();
        initIdx = Integer.parseInt(input);
        dists[initIdx].dist = 0;
    }


    private static void dijkstra(List<Node> list, Node prevNode) {
        for (int idx = 0; idx < list.size(); idx++) {
            if ( (dists[list.get(idx).idx].dist == Integer.MAX_VALUE) || dists[list.get(idx).idx].dist > dists[prevNode.idx].dist + list.get(idx).weight ) {
                dists[list.get(idx).idx].dist = dists[prevNode.idx].dist + list.get(idx).weight;
                dists[list.get(idx).idx].node = list.get(idx);
                list.get(idx).prev = prevNode;
                prevNode.next = list.get(idx);
                dijkstra(graph.get(list.get(idx).idx), list.get(idx));
            }
        }
    }


    private static void printResult() {
        for (int idx = 1; idx <= N; idx++) {
            System.out.println(idx + ": " + dists[idx].dist);
        }
    }
}
