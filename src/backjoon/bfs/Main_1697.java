package backjoon.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {
    static int N, K, answer;
    static boolean[] v;
    static Queue<Integer> queue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(N>=K) System.out.println(N-K);
        else {
            v = new boolean[100001];
            queue = new LinkedList<>();
            queue.offer(N);
            v[N] = true;
            gameStart();
            System.out.println(answer);
        }
    }
    private static void gameStart() {
        int cnt = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                if(move()) {
                    answer = cnt;
                    return;
                }
            }
            cnt++;
        }
    }
    private static boolean move() {
        int c = queue.poll();
        if(c == K) return true;
        if(c-1>=0 && !v[c-1]) {
            v[c-1] = true;
            queue.offer(c-1);
        }
        if(c+1<v.length && !v[c+1]) {
            v[c+1] = true;
            queue.offer(c+1);
        }
        if(c*2<v.length && !v[c*2]) {
            v[c*2] = true;
            queue.offer(c*2);
        }
        return false;
    }

}