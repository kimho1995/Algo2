package backjoon.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2066 {

    static int V, E, answer;
    static boolean[] v;
    static List<List<Integer>> list;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0; i<=V; i++) {
            list.add(new ArrayList<>());
        }
        queue = new LinkedList<>();
        v = new boolean[V+1];
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }

        if(list.get(1).size() != 0) {
            start();
        }
        System.out.println(answer);
        br.close();
    }

    static void start() {
        queue.offer(1);
        v[1] = true;

        while(!queue.isEmpty()) {
            int num = queue.poll();
            int size = list.get(num).size();
            for(int i=0; i<size; i++) {
                int n = list.get(num).get(i);
                if(v[n]) continue;
                v[n] = true;
                queue.offer(n);
                answer++;
            }
        }
    }

}