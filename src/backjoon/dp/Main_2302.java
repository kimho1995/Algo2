package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2302 {

    static int N, M, answer;
    static int[] dp;
    static boolean[] vip;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        vip = new boolean[N+1];
        dp = new int[N+1];
        for(int i=0; i<M; i++) {
            vip[Integer.parseInt(br.readLine())] = true;
        }
        dp[1] = dp[2] = 1;

        for(int i=3; i<=N; i++) {
            if(vip[i-1] | vip[i-2]) {
                dp[i] = dp[i-1];
            } else  {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        if(vip[N]) answer = dp[N];
        else answer = dp[N]+dp[N-1];

        System.out.println(answer);

        br.close();
    }

}