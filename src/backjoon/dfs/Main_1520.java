package backjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520 {

    static int N, M, answer;
    static Integer[][] dp;
    static int[][] map;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new Integer[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));

        br.close();
    }

    static int dfs(int r, int c) {
        if(r==N-1 && c==M-1) {
            return 1;
        }
        if(dp[r][c] == null) {
            dp[r][c] = 0;
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (contain(nr, nc)  && map[nr][nc] < map[r][c]) {
                    dp[r][c] += dfs(nr, nc);
                }
            }
        }
        return dp[r][c];
    }

    static boolean contain(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }
}