import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
    static int N, M;
    static int[][] arr;
    static int[][] map;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        map = new int[N+1][M+1];
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(br.readLine());
            for(int j=1; j<=M; j++) {
                arr[i][j] = sb.charAt(j-1)-'0';
            }
            sb.setLength(0);
        }
        setting();

        for(int i=1; i<N; i++) {
            for(int j=1; j<=M; j++) {
                start(i, j);
            }
        }

        System.out.println(answer);
    }

    static void setting() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                map[i][j] = map[i][j-1]+arr[i][j];
            }
        }

        for(int i=1; i<N; i++) {
            for(int j=1; j<=M; j++) {
                map[i+1][j] += map[i][j];
            }
        }
    }

    static void start(int r, int c) {
        if(r==N && c==M) return;
        if(c==M) {
            
            return;
        }
        if(r==N) {

            return;
        }
        answer = Math.max(answer, map[r][c] * (map[r][M] - map[r][c]) * (map[N][M]-map[r][M]));
        answer = Math.max(answer, map[r][c] * (map[N][c] - map[r][c]) * (map[N][M]-map[N][c]));
        return;
    }

}
