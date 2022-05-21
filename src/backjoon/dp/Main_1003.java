package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003 {

    static int T, N;
    static int[] zero, one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            zero = new int[N+1];
            one = new int[N+1];
            if(N==0) System.out.println(1 + " " + 0);
            else if(N==1) System.out.println(0 + " " + 1);
            else {
                zero[0] = 1;
                one[1] = 1;
                calc(2);
                System.out.println(zero[N] + " " + one[N]);
            }
        }

        br.close();
    }

    static void calc(int current) {
        if(current == N) {
            zero[current] = zero[current-2] + zero[current-1];
            one[current] = one[current-2] + one[current-1];
            return;
        }
        zero[current] = zero[current-2] + zero[current-1];
        one[current] = one[current-2] + one[current-1];
        calc(current+1);
    }

}