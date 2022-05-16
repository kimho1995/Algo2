package backjoon.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {

    static int N,M, answer;
    static int[][] map;
    static boolean[][] v;
    static Queue<int[]> queue;
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

        start();
        System.out.println(answer);
        br.close();
    }

    static void start(){
        queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        v[0][0] = true;

        while(!queue.isEmpty()) {
            int[] move = queue.poll();
            for(int d=0; d<dr.length; d++) {
                int r = move[0] + dr[d];
                int c = move[1] + dc[d];
                if(!isMove(r, c) || map[r][c] == 0 || v[r][c]) continue;
                if(r==N-1 && c==M-1) {
                    answer = move[2]+1;
                    return;
                }
                v[r][c] = true;
                queue.offer(new int[]{r,c,move[2]+1});
            }
        }
    }

    static boolean isMove(int r, int c) {
        return r>=0&&r<N && c>=0&&c<M;
    }
}