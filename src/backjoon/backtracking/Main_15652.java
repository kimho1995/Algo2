package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        sb = new StringBuilder();
        start(1, 0);
        System.out.println(sb.toString());

        br.close();
    }

    static void start(int start, int cnt) {
        if(cnt == M) {
            for(int n : arr) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=N; i++) {
            arr[cnt] = i;
            start(i, cnt+1);
        }
    }

}