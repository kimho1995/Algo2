package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2581 {

    static int M, N, min, sum;
    static boolean[] prime;
    /*
    1. 에라토스테네스 체 사용 해서 최대 소수가 아닐시 boolean 배열에 true
    2. 주어진 M과 N사이에 최소 소수값을 저장하면서 소수들을 더함
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        prime = new boolean[N+1];
        min = -1;
        start();
        for(int i=M; i<=N; i++) {
            if(!prime[i]) {
                if(min == -1) min = i;
                sum += i;
            }
        }
        if(min == -1) System.out.println(min);
        else System.out.println(sum + "\n" + min);
        br.close();
    }

    static void start() {
        prime[0] = prime[1] = true;
        for(int i=2; i*i<=N; i++) {
            if(!prime[i]) {
                for(int j=i*i; j<=N; j+=i) prime[j] = true;
            }
        }
    }
}