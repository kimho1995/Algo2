package backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9020 {
    static int T;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        prime = new boolean[10001];
        prime[0] = prime[1] = true;
        setting();
        for(int t=1; t<=T; t++) {
            int n = Integer.parseInt(br.readLine());
            calc(n);
        }

        br.close();
    }

    static void setting() {
        for(int i=2; i*i<=prime.length-1; i++) {
            if(prime[i]) continue;
            for(int j=i*i; j<=prime.length-1; j+=i) prime[j] = true;
        }
    }

    static void calc(int n) {
        int mid = n/2;
        for(int i=0; i<mid; i++) {
            if(!prime[mid-i] && !prime[mid+i]) {
                System.out.println((mid-i) + " " + (mid+i));
                break;
            }
        }
    }

}