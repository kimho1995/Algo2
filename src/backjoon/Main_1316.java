package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1316 {

    static int T, answer;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb;
        answer = T;
        for(int t=1; t<=T; t++) {
            visit = new boolean[26];
            sb = new StringBuilder();
            sb.append(br.readLine());
            int prev = sb.charAt(0)-'a';
            int c = -1;
            boolean status = true;
            for(int i=1; i<sb.length(); i++) {
                c = sb.charAt(i)-'a';
                if(prev == c) continue;
                if(visit[prev]) {
                    status = false;
                    break;
                }
                visit[prev] = true;
                prev = c;
            }
            if((c != -1 && visit[c]) || !status) {
                answer--;
            }
        }
        System.out.println(answer);

        br.close();
    }
}