package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_19621 {

    static class Node implements Comparable<Node> {
        int s, e, p;
        public Node(int s, int e, int p) {
            this.s = s;
            this.e = e;
            this.p = p;
        }
        @Override
        public int compareTo(Node o) {
            if(this.s==o.s) {
                return this.e-o.e;
            }
            return this.s-o.s;
        }
    }

    static int N;
    static List<Node> list;
    static List<Node> dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dp = new ArrayList<>();
        list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        if(list.size()==1) System.out.println(list.get(0).p);
        else {
            Collections.sort(list);

            Node a = list.get(0);
            Node b = list.get(1);
            if (a.e <= b.s) {
                dp.add(a);
                dp.add(new Node(b.s, b.e, a.p + b.p));
            } else {
                if (a.p > b.p) {
                    dp.add(b);
                    dp.add(a);
                } else {
                    dp.add(a);
                    dp.add(b);
                }
            }

            for (int i = 2; i < N; i++) {
                Node now = list.get(i);
                if (dp.get(i - 1).e <= now.s) {
                    dp.add(new Node(now.s, now.e, now.p + dp.get(i - 1).p));
                } else {
                    for (int j = i - 2; j >= 0; j--) {
                        if (dp.get(j).e <= now.s) {
                            dp.add(new Node(now.s, now.e, now.p + dp.get(j).p));
                            break;
                        }
                    }
                }
            }
            System.out.println(Math.max(dp.get(N - 1).p, dp.get(N - 2).p));
        }
        br.close();
    }

}