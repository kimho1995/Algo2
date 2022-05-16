package backjoon.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 {

    static int N, answer, max;
    static int[][] map;
    static boolean[][] v;
    static Queue<int[]> queue;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }
        queue = new LinkedList<>();
        for(int i=0; i<max; i++) {
            int sec = start(i);
            answer = Math.max(answer, sec);
        }

        System.out.println(answer);
        br.close();
    }

    static int start(int depth) {
        v = new boolean[N][N];
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(v[i][j] || map[i][j]<=depth) continue;
                bfs(i, j, depth);
                count++;
            }
        }
        return count;
    }

    static void bfs(int i, int j, int depth) {
        queue.offer(new int[]{i, j});
        v[i][j] = true;

        while(!queue.isEmpty()) {
            int[] rc = queue.poll();
            for(int d=0; d<4; d++) {
                int r = rc[0] + dr[d];
                int c = rc[1] + dc[d];
                if(!isMove(r,c) || v[r][c] || map[r][c]<=depth) continue;
                v[r][c] = true;
                queue.offer(new int[]{r,c});
            }
        }

    }

    static boolean isMove(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }

}