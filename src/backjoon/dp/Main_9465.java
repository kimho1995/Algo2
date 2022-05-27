package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9465 {

    static int T, N;
    static int[] map;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[2*N+1];
            dp = new Integer[2*N+1];

            for(int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[j+N*i] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0] = map[0];
            dp[1] = map[1];
            start(2*N);
            System.out.println(Arrays.toString(dp));
        }

        br.close();
    }

    static int start(int idx) {
        if(dp[idx] == null) {
            dp[idx] = Math.max(Math.max(start(idx-3)+map[idx-1], start(idx-2)) + map[idx], start(idx-1));
        }
        return dp[idx];
    }

}