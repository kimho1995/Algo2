package backjoon.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1012 {

    static int T, N, M, K, answer;
    static int[][] map;
    static boolean[][] v;
    static Queue<int[]> queue;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            v = new boolean[N][M];
            answer = 0;
            queue = new LinkedList<>();

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[r][c] = 1;
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(!v[i][j] && map[i][j]==1) {
                        start(i, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);

        }

        br.close();
    }

    static void start(int i, int j) {
        queue.offer(new int[]{i, j});
        v[i][j] = true;

        while (!queue.isEmpty()) {
            int[] rc = queue.poll();
            for(int d=0; d<4; d++) {
                int r = rc[0] + dr[d];
                int c = rc[1] + dc[d];
                if(!isMove(r, c) || v[r][c] || map[r][c] == 0) continue;
                v[r][c] = true;
                queue.offer(new int[]{r,c});
            }

        }
    }

    static boolean isMove(int r, int c) {
        return r>=0 && r<N && c>=0 && c<M;
    }

}