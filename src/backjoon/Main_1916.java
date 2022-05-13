package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1916 {

    static class Node implements Comparable<Node>{
        int cityNum;
        int distance;
        public Node(int cityNum, int distance) {
            this.cityNum = cityNum;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    static int N, M, S, E;
    static List<List<Node>> graph;
    static int[] dist;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new ArrayList<>();
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(S);

        System.out.println(dist[E]);


        br.close();
    }

    static void dijkstra(int start) {
        pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(node.distance>dist[node.cityNum]) continue;
            for(Node linkNode : graph.get(node.cityNum)) {
                if(node.distance+linkNode.distance<dist[linkNode.cityNum]) {
                    dist[linkNode.cityNum] = node.distance+linkNode.distance;
                    pq.offer(new Node(linkNode.cityNum, dist[linkNode.cityNum]));
                }
            }
        }
    }

}