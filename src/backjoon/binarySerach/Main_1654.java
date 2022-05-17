package backjoon.binarySerach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654 {

    static int K, N;
    static long max, min;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<K; i++) {
            max = Math.max(max, arr[i]);
        }

        max++;

        System.out.println(binarySearch());

        br.close();
    }

    static long binarySearch() {
        while(min<max) {
            long mid = (min+max)/2;
            long count = 0;
            for(int n : arr) {
                count += (n/mid);
            }

            if(count<N) {
                max = mid;
            } else {
                min = mid+1;
            }
        }

        return min-1;
    }
}