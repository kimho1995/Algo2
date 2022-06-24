package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1309 {

    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        arr[0] = 1;
        int sum = 0;
        for(int i=1; i<N; i++) {
            arr[i] = 1+arr[i-1]+sum;
            sum += arr[i-1]*2;
            arr[i]%=9901;
        }
        long answer = 0;
        for(int i=0; i<N; i++) {
            answer += arr[i];
            answer%=9901;
        }
        answer = (answer*2+1)%9901;
        System.out.println(answer);
        br.close();
    }
}