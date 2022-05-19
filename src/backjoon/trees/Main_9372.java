package backjoon.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_9372 {
    static class Node implements Comparable<Node> {
        int idx;
        int weight;
        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int T, N, M, answer;
    static PriorityQueue<Node> pq;
    static boolean[] v;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new ArrayList[N+1];
            v = new boolean[N+1];
            for(int i=0; i<=N; i++) {
                list[i] = new ArrayList<>();
            }
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(new Node(b, 1));
                list[b].add(new Node(a, 1));
            }
            start();
            System.out.println(answer);
        }


        br.close();
    }

    static void start() {
        pq = new PriorityQueue<>();
        pq.offer(new Node(1, 1));
        v[1] = true;
        answer = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for(Node next : list[node.idx]) {
                if(v[next.idx]) continue;
                v[next.idx] = true;
                pq.offer(new Node(next.idx, next.weight));
                answer++;
            }
        }
    }

}