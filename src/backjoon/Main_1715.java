package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715 {

    static int N;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        System.out.println(calc());

        br.close();
    }

    static int calc(){
        int sum = 0;
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            sum += (a+b);
            pq.offer(sum);
        }
        return sum;
    }
}