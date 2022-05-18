package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2580 {
    static final int N = 9;
    static int[][] map;
    static boolean[][] row;
    static boolean[][] col;
    static boolean[][] square;
    static int count;
    static boolean exit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[N][N];
        row = new boolean[N][N+1];
        col = new boolean[N][N+1];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int num = map[i][j];
                if(num == 0) count++;
                else {
                    row[j][num] = true;
                    col[i][num] = true;
                }
            }
        }

        start(0, 0, 0);

        br.close();
    }

    static void start(int r, int c, int cnt) {
        if(exit) return;
        if(r==N) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            exit = true;
            return;
        }
        if(c==N) {
            start(r+1, 0, cnt);
            return;
        }

        if(map[r][c] == 0) {
            for (int i = 1; i <= N; i++) {
                if(!row[c][i] && !col[r][i] && square(r, c, i)) {
                    map[r][c] = i;
                    row[c][i] = true;
                    col[r][i] = true;
                    start(r, c+1, cnt+1);
                    map[r][c] = 0;
                    row[c][i] = false;
                    col[r][i] = false;
                }
            }
            return;
        }
        start(r, c+1, cnt);
    }

    static boolean square(int r, int c, int n) {
        int sr = r/3*3;
        int sc = c/3*3;
        for(int i=sr; i<sr+3; i++) {
            for(int j=sc; j<sc+3; j++) {
                if(map[i][j] == n) return false;
            }
        }
        return true;
    }

}