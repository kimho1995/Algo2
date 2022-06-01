package backjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13565 {

    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = sb.charAt(j)-'0';
            }
            sb.setLength(0);
        }

        for(int i=0; i<M; i++) {
            if(!v[0][i] && map[0][i] == 0) {
                v[0][i] = true;
                dfs(0, i);
            }
        }
        System.out.println("NO");
        br.close();
    }

    static void dfs(int r, int c) {
        if(r==N-1) {
            System.out.println("YES");
            System.exit(0);
        }
        for(int d=0; d<dr.length; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];
            if(isContain(nr, nc) && !v[nr][nc] && map[nr][nc]==0) {
                v[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }

    static boolean isContain(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }
}