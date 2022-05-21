package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932 {

    static int N;
    static int[][] arr;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new Integer[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            dp[N-1][i] = arr[N-1][i];
        }

        start(0, 0);

        System.out.println(dp[0][0]);

        br.close();
    }

    static int start(int depth, int idx) {
        if(depth == N-1) return dp[depth][idx];
        if(dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(start(depth+1, idx), start(depth+1, idx+1))+arr[depth][idx];
        }
        return dp[depth][idx];
    }

}