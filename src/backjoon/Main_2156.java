package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2156 {

    static int N, max;
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new Integer[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];
        if(N>=2) {
            dp[2] = arr[1]+arr[2];
        }

        start(N);

        System.out.println(dp[N]);

        br.close();
    }

    static int start(int idx) {
        if(dp[idx] == null) {
            dp[idx] = Math.max(Math.max(start(idx-3)+arr[idx-1], start(idx-2)) + arr[idx], start(idx-1));
        }
        return dp[idx];
    }

}