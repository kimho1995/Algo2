package backjoon.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11725 {

    static int N;
    static List<Integer>[] list;
    static boolean[] v;
    static int[] map;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        map = new int[N+1];
        v = new boolean[N+1];
        for(int i=0; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        start();

        for(int i=2; i<=N; i++) {
            System.out.println(map[i]);
        }

        br.close();
    }

    static void start() {
        queue = new LinkedList<>();
        queue.offer(1);
        v[1] = true;
        while(!queue.isEmpty()) {
            int n = queue.poll();

            for(int q : list[n]) {
                if(v[q]) continue;
                v[q] = true;
                map[q] = n;
                queue.offer(q);
            }
        }
    }

}