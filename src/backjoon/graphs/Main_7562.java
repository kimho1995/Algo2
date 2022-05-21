package backjoon.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_7562 {

    static int T, L, answer;
    static int[] se;
    static boolean[][] v;
    static Queue<int[]> queue;
    static int[] dr = {2,2,-2,-2,1,1,-1,-1};
    static int[] dc = {1,-1,-1,1,2,-2,-2,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            L = Integer.parseInt(br.readLine());
            v = new boolean[L][L];
            se = new int[4];
            for(int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                se[i*2] = Integer.parseInt(st.nextToken());
                se[i*2+1] = Integer.parseInt(st.nextToken());
            }
            start();
            System.out.println(answer);
        }

        br.close();
    }

    static void start() {
        queue = new LinkedList<>();
        queue.offer(new int[]{se[0], se[1], 0});
        v[se[0]][se[1]] = true;
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            if(arr[0] == se[2] && arr[1] == se[3]) {
                answer = arr[2];
                break;
            }
            for(int d=0; d<dr.length; d++) {
                int nr = arr[0] + dr[d];
                int nc = arr[1] + dc[d];
                if(!isContain(nr, nc) || v[nr][nc]) continue;
                v[nr][nc] = true;
                queue.offer(new int[]{nr, nc, arr[2]+1});
            }
        }
    }

    static boolean isContain(int r, int c) {
        return r>=0 && r<L && c>=0 && c<L;
    }

}