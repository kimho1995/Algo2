package backjoon.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15900 {

    static int N, answer;
    static boolean[] v;
    static List<Integer>[] list;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
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
        System.out.println(answer%2==0?"No":"Yes");
        br.close();
    }

    static void start() {
        queue = new LinkedList<>();
        queue.offer(new int[]{1,0});
        v[1] = true;
        int depth = 0;
        while(!queue.isEmpty()) {
            int[] n = queue.poll();
            int cnt = 0;
            for(int next : list[n[0]]) {
                if(v[next]) continue;
                v[next] = true;
                queue.offer(new int[]{next, n[1]+1});
                cnt++;
            }
            if(cnt==0) answer += n[1];
        }
    }

}