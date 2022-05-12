package backjoon;

import java.io.*;
import java.util.*;

public class Main_18352 {

    static final int INF = 9999999;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] result;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken()); // 정점
        int M=Integer.parseInt(st.nextToken());// 간선
        int K=Integer.parseInt(st.nextToken());
        int X=Integer.parseInt(st.nextToken());

        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        result = new int[N+1];

        Arrays.fill(result, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), 1));
        }

        dijkstra(X);

        answer = new ArrayList<>();

        for (int i = 1; i < result.length; i++) {
            if(result[i] == K) {
                answer.add(i);
            }
        }

        if(answer.size() == 0) System.out.println(-1);
        else {
            for(int i=0; i<answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }

        br.close();
    }

    static void dijkstra(int index) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        result[index] = 0;
        pq.offer(new Node(index, 0));
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int nodeIndex = node.index;
            int distance = node.distacne;
            if(distance > result[nodeIndex]) {
                continue;
            }
            for (Node linkedNode : graph.get(nodeIndex)) {
                if(distance + linkedNode.distacne < result[linkedNode.index]) {
                    result[linkedNode.index] = distance + linkedNode.distacne;
                    pq.offer(new Node(linkedNode.index, result[linkedNode.index]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        int distacne;
        Node(int index, int distacne) {
            this.index = index;
            this.distacne = distacne;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distacne, o.distacne);
        }
    }
}