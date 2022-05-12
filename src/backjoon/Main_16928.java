package backjoon;

import java.io.*;
import java.util.*;

public class Main_16928 {
    static class Node {
        int num;
        int cnt;
        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    static int N, M, answer;
    static boolean[] visited;
    static Map<Integer, Integer> move;
    static Queue<Node> bfs;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        move = new HashMap<>();

        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            move.put(k, v);
        }
        answer = Integer.MAX_VALUE;
        start(1);
        System.out.println(answer);
        br.close();
    }

    static void start(int startVertex) {
        visited = new boolean[101];
        bfs = new LinkedList<>();
        visited[startVertex] = true;
        bfs.offer(new Node(startVertex, 0));
        while (!bfs.isEmpty()) {
            Node node = bfs.poll();
            for(int i=1; i<=6; i++) {
                int num = node.num+i;
                if(num == 100) {
                    answer = Math.min(answer, node.cnt+1);
                    break;
                }
                if(answer <= node.cnt+1 || visited[num]) continue;
                visited[num] = true;
                if(move.containsKey(num)) {
                    num = move.get(num);
                    visited[num] = true;
                }
                bfs.offer(new Node(num, node.cnt+1));
            }

        }
    }
}