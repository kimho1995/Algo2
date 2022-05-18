package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182 {
    static int N, S, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        start(0, 0);
        if(S == 0)
            System.out.println(answer-1);
        else
            System.out.println(answer);
        br.close();
    }

    static void start(int cnt, int sum) {
        if(cnt == N) {
            if(sum == S) {
                answer++;
            }
            return;
        }
        start(cnt+1, sum+arr[cnt]);
        start(cnt+1, sum);
    }
}