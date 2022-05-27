package backjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2644 {

    static int N, S, E, M, answer;
    static List<Integer>[] list;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        v = new boolean[N+1];
        v[S] = true;
        answer = -1;

        dfs(S, 0);

        System.out.println(answer);

        br.close();
    }

    static void dfs(int start, int cnt) {
        if(start == E) {
            answer = cnt;
            return;
        }
        for(int i : list[start]) {
            if(!v[i]) {
                v[i] = true;
                dfs(i, cnt+1);
            }
        }
    }
}