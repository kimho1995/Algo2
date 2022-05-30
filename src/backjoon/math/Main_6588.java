package backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_6588 {
    static final int N = 1000000;
    static boolean[] prime;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        start();
        int num= Integer.parseInt(br.readLine());
        while(num!=0) {
            calc(num);
            num= Integer.parseInt(br.readLine());
        }

        System.out.println(sb.toString());

        br.close();

    }

    static void start() {
        prime = new boolean[N+1];
        for(int i=2; i*i<=N; i++) {
            if(prime[i]) continue;
            for(int j=i*i; j<=N; j+=i) prime[j] = true;
        }
    }

    static void calc(int num) {
        for(int i=3; i<num; i++) {
            if(!prime[i]) {
                int sum = num-i;
                if(!prime[sum]) {
                    sb.append(num + " = " + i + " + " + sum + "\n");
                    return;
                }
            }
        }
        sb.append("Goldbach's conjecture is wrong.");
    }

}