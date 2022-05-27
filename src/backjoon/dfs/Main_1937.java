package backjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1937 {

    static int N, sum, answer;
    static int[][] map;
    static Integer[][] dp;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new Integer[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(dp[i][j] == null) {
                    dfs(i, j);
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(answer < dp[i][j]) {
                    answer = dp[i][j];
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

    static int dfs(int r, int c) {
        if(dp[r][c] == null) {
            dp[r][c] = 1;
            for(int d=0; d<dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isContain(nr, nc) && map[r][c]<map[nr][nc]) {
                    sum += dfs(nr,nc);
                    dp[r][c] = Math.max(dp[r][c], sum+1);
                    sum = 0;
                }
            }
        }
        return dp[r][c];
    }

    static boolean isContain(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }

}