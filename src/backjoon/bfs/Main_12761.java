package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12761 {
    static int A, B, N, M, answer;
    static Queue<Integer> queue;
    static boolean[] visit;
    static int[] cal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];
        cal = new int[]{1,-1,A,-A,B,-B};
        queue = new LinkedList<>();
        queue.offer(N);
        visit[N] = true;
        answer = 1;
        if(N!=M) {
            start();
        }

        System.out.println(answer);

        br.close();
    }

    static void start() {
       while(!queue.isEmpty()) {
           int size = queue.size();
           for(int i=0; i<size; i++) {
               int n = queue.poll();
               for(int d=0; d<6; d++) {
                   int nd = n+cal[d];
                   if(nd == M) {
                       return;
                   }
                   if(nd>=0 && nd<=100000 && !visit[nd]) {
                       visit[nd] = true;
                       queue.offer(nd);
                   }
               }
               int mulA = n*A;
               int mulB = n*B;
               if(mulA == M || mulB == M) {
                   return;
               }
               if(mulA<=100000 && !visit[mulA]) {
                   visit[mulA] = true;
                   queue.offer(mulA);
               }
               if(mulB<=100000 && !visit[mulB]) {
                   visit[mulB] = true;
                   queue.offer(mulB);
               }
           }
           answer++;
       }
    }

}