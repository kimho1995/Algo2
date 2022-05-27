package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1495 {

    static int N, S, M;
    static int[] map, dp;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N];
        dp = new int[M+1];
        Arrays.fill(dp, -1);
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        dp[S] = 0;
        list = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            list = new ArrayList<>();
            for(int j=0; j<=M; j++) {
                if(dp[j] == i-1) {
                    int plus = j + map[i-1];
                    int minus = j - map[i-1];
                    if (plus <= M) {
                        list.add(plus);
                    }
                    if (0 <= minus) {
                        list.add(minus);
                    }
                }
            }
            for(int n : list) dp[n] = i;
        }
        int max = -1;
        for(int i=0; i<dp.length; i++) {
            if(dp[i] == N) max = Math.max(max, i);
        }

        System.out.println(max);

        br.close();
    }

}