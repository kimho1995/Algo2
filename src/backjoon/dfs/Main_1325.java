package backjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1325 {

    static int N, M;
    static List<Integer>[] list;
    static boolean[] v;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        arr = new int[N+1];
        for(int i=0; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
        }

        for(int i=1; i<=N; i++) {
            v = new boolean[N+1];
            dfs(i);
        }

        int max = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            max = Math.max(max, arr[i]);
        }
        for(int i=1; i<=N; i++) {
            if(max == arr[i]) sb.append(i + " ");
        }

        System.out.println(sb);

        br.close();
    }

    static void dfs(int n) {
        v[n] = true;
        for(int i : list[n]) {
            if(!v[i]) {
                arr[i] ++;
                dfs(i);
            }

        }
    }
}

/*
 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.util.*;

 public class Main_1325 {
 public static List<Integer>[] list;
 public static int[] cnt;
 public static int n, m;

 public static void main(String[] args) throws IOException {
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 String[] str = br.readLine().split(" ");
 n = Integer.parseInt(str[0]);
 m = Integer.parseInt(str[1]);
 list = new ArrayList[n+1];

 for(int i=0;i<=n;i++){
 list[i] = new ArrayList<Integer>();
 }
 for(int i=0;i<m;i++){
 String[] data = br.readLine().split(" ");
 int a = Integer.parseInt(data[0]);
 int b = Integer.parseInt(data[1]);
 list[a].add(b);

 }

 cnt = new int[n+1];

 for(int i=1;i<=n;i++){
 bfs(i);
 }

 ArrayList<Integer> ans = new ArrayList<>();
 int max_value = 0;
 for(int i=1;i<=n;i++){
 if(cnt[i] > max_value){
 max_value = cnt[i];
 ans.clear();
 ans.add(i);
 } else if (cnt[i] == max_value){
 ans.add(i);
 }
 }

 for(int a:ans){
 System.out.print(a+" ");
 }


 }

 public static void bfs(int start){
 boolean[] visited = new boolean[n+1];
 Queue<Integer> q = new LinkedList<>();
 visited[start] = true;
 q.offer(start);

 while (!q.isEmpty()) {
 int x = q.poll();
 for (int num : list[x]) {
 if (!visited[num]) {
 cnt[num]++;
 visited[num] = true;
 q.offer(num);
 }
 }
 }


 }

 }
 */