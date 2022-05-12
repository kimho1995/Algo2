import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<N+1; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }
        boolean[] visit = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        visit[X] = true;
        int cnt = 0;
        while(!queue.isEmpty()) {
            if(cnt == K) break;
            int size = queue.size();
            for(int s=0; s<size; s++) {
                int q = queue.poll();
                for(int i=0; i<list.get(q).size(); i++) {
                    int n = list.get(q).get(i);
                    if(visit[n]) continue;
                    visit[n] = true;
                    queue.add(n);
                }
            }
            cnt++;
        }
        if(queue.isEmpty()) bw.write("-1");
        else {
            while (!queue.isEmpty()) {
                bw.write(queue.poll()+"");
            }
        }
        bw.close();
    }
}
