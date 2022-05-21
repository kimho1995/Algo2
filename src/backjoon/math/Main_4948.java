package backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4948 {
    static int N;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        while(N!=0) {
            start();
            System.out.println(calc());
            N = Integer.parseInt(br.readLine());
        }

        br.close();
    }

    static void start() {
        prime = new boolean[2*N+1];
        for(int i=2; i*i<=2*N; i++) {
            if(prime[i]) continue;
            for(int j=i*i; j<=2*N; j+=i) prime[j] = true;
        }
    }

    static int calc() {
        int count = 0;
        for(int i=N+1; i<=2*N; i++) {
            if(!prime[i]) count++;
        }
        return count;
    }

}