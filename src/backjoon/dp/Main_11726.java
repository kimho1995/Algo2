package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        if(N==1) System.out.println(1);
        else if(N==2) System.out.println(2);
        else {
            start();
            System.out.println(arr[N]);
        }
        br.close();
    }

    static void start() {
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3; i<=N; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }
    }
}