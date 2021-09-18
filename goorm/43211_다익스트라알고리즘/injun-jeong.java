package goorm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q43211 {
    private static BufferedReader br;
    private static int N, E;
    private static ArrayList<List<Node>> graph;
    private static int[] dist;
    private static int initIdx;


    static class Node {
        int idx, weight;

        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
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
        Node startNode = new Node(initIdx, 0);
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
        dist = new int[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            dist[idx] = Integer.MAX_VALUE;
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
            int srcIdx = Integer.parseInt(inputs[0]);
            int destIdx = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);

            /* create node */
            Node srcNode = new Node(srcIdx, weight);
            Node destNode = new Node(destIdx, weight);

            /* create edge */
            graph.get(srcIdx).add(destNode);
            graph.get(destIdx).add(srcNode);
        }

        String input = br.readLine();
        initIdx = Integer.parseInt(input);
        dist[initIdx] = 0;
    }


    private static void dijkstra(List<Node> list, Node prevNode) {
        for (int idx = 0; idx < list.size(); idx++) {
            if ( (dist[list.get(idx).idx] == Integer.MAX_VALUE) || dist[list.get(idx).idx] > dist[prevNode.idx] + list.get(idx).weight ) {
                dist[list.get(idx).idx] = dist[prevNode.idx] + list.get(idx).weight;
                dijkstra(graph.get(list.get(idx).idx), list.get(idx));
            }
        }
    }


    private static void printResult() {
        for (int idx = 1; idx <= N; idx++) {
            System.out.println(idx + ": " + dist[idx]);
        }
    }
}
