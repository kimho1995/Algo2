package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9657 {

    static int N;
    static int[] stone;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        stone = new int[]{4, 3, 1};
        dp = new int[N+4];
        //1 -> 상근 승
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;
        for(int i=5; i<=N; i++) {
            for(int j=0; j<stone.length; j++) {
                if(dp[i-stone[j]] == 0) {
                    dp[i] = 1;
                    break;
                }
            }
        }

        System.out.println(dp[N]==1?"SK":"CY");

        br.close();
    }

}