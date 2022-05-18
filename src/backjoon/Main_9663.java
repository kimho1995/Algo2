package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663 {

    static int N, total;
    static boolean[] v, v1, v2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        total = 0;
        v = new boolean[N+1];
        v1 = new boolean[2*N+1];
        v2 = new boolean[2*N+1];
        calc(1);
        System.out.println(total);

    }

    static void calc(int cnt){
        if(cnt == N+1) {
            total++;
            return;
        }
        for(int i=1; i<=N; i++) {
            if(v[i] || v1[N+(cnt-i)] || v2[i+cnt-1]) continue;
            v[i] = true;
            v1[N+(cnt-i)] = true;
            v2[i+cnt-1] = true;
            calc(cnt+1);
            v[i] = false;
            v1[N+(cnt-i)] = false;
            v2[i+cnt-1] = false;
        }
    }
}