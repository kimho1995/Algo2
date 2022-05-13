package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579 {

    static int N;
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new Integer[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        dp[1] = arr[1];
        if(N>=2)
            dp[2] = arr[1] + arr[2];
        start(N);
        System.out.println(dp[N]);
        br.close();
    }

    static int start(int num) {
        if(dp[num] == null) {
            dp[num] = Math.max(start(num-2), start(num-3)+arr[num-1]) + arr[num];
        }
        return dp[num];
    }

}