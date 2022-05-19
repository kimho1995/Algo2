package backjoon.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_9934 {

    static int K, N;
    static int[] map;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        N = (int) (Math.pow(2, K)-1);
        map = new int[N];
        list = new ArrayList[K];
        for(int i=0; i<K; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        start(0,N, 0);
        for(int i=0; i<K; i++) {
            for(int n : list[i]) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        br.close();
    }

    static void start(int left, int right, int cnt) {
        if(left>right) return;
        int mid = (left+right)/2;
        if(mid>=N) return;
        list[cnt].add(map[mid]);
        start(left, mid-1, cnt+1);
        start(mid+1, right, cnt+1);
    }

}