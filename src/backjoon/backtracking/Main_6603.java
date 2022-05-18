package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603 {
    static int N;
    static int[] arr;
    static int[] idx;
    static boolean[] v;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N==0) break;
            arr = new int[N];
            idx = new int[6];
            v= new boolean[N];
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb = new StringBuilder();
            start(0, 0);
            System.out.println(sb.toString());
        }


        br.close();
    }

    static void start(int start, int cnt) {
        if(cnt == 6) {
            for(int n : idx) {
                sb.append(arr[n] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<N; i++) {
            if(v[i]) continue;
            v[i] = true;
            idx[cnt] = i;
            start(i+1, cnt+1);
            v[i] = false;
        }
    }
}