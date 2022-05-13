package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095 {

    static int T, N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            answer = 0;
            start(0);
            System.out.println(answer);
        }

        br.close();
    }

    static void start(int sum) {
        if(N < sum) return;
        if(N == sum) {
            answer++;
            return;
        }
        start(sum+1);
        start(sum+2);
        start(sum+3);
    }
}