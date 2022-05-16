package backjoon.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11724 {

    static int N, M, answer;
    static boolean[] v;
    static List<List<Integer>> list;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        queue = new LinkedList<>();
        v = new boolean[N+1];
        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i=1; i<=N; i++) {
            if(v[i]) continue;
            start(i);
            answer++;
        }
        System.out.println(answer);
        br.close();
    }

    static void start(int n) {
        queue.offer(n);
        v[n] = true;

        while(!queue.isEmpty()) {
            int num = queue.poll();
            int size = list.get(num).size();
            for(int i=0; i<size; i++) {
                int x = list.get(num).get(i);
                if(v[x]) continue;
                v[x] = true;
                queue.offer(x);
            }
        }
    }

}