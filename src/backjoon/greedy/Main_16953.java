package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16953 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(calc());

        br.close();
    }

    static int calc() {
        int cnt = 0;
        int cal = M;
        while(cal != 0) {
            if(cal == N) {
                return cnt+1;
            }
            if(cal%2==0) {
                cal/=2;
            }else {
                if(cal%10!=1) return -1;
                cal/=10;
            }
            cnt++;
        }
        return -1;
    }
}