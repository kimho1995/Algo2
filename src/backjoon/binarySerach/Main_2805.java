package backjoon.binarySerach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805 {

    static int N;
    static long M, max, min;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        System.out.println(binarySearch());

        br.close();
    }

    static long binarySearch() {
        long lo = min;
        long hi = max;
        while(lo<hi) {
            long mid = (lo+hi)/2;
            long sum = 0;
            for(long n : arr) {
                if(sum > M) break;
                if(n-mid>0) {
                    sum += n-mid;
                }
            }

            if(sum < M) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo-1;
    }
}