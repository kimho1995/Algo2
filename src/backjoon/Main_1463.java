package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463 {

    static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        calc(N, 0);
        System.out.println(answer);
        br.close();
    }

    static void calc(int n, int cnt) {
        if(answer < cnt) return;
        if(n == 1) {
            answer = Math.min(answer, cnt);
            return;
        }
        if(n%3==0) {
            calc(n/3, cnt+1);
        }
        if(n%2==0) {
            calc(n/2, cnt+1);
        }
        calc(n-1, cnt+1);
    }
}