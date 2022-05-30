package backjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9466 {

    static int T, N, answer;
    static int[] map;
    static boolean[] v, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N+1];
            v = new boolean[N+1];
            d = new boolean[N+1];
            answer = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<=N; i++) {
                if(!d[i])
                    dfs(i);
            }

            System.out.println(N - answer);
        }

        br.close();
    }

    static void dfs(int start) {
        if(d[start]) return;
        if(v[start]) {
            d[start]=true;
            answer++;
        }
        v[start] = true;
        dfs(map[start]);
        d[start] = true;
        v[start] = false;
    }
}