package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15886 {
    static int N, answer;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for(int i=0; i<N; i++) {
            char c = str.charAt(i);
            if(c=='W') {
                if(flag) answer++;
                flag = false;
                continue;
            }
            flag = true;
        }
        System.out.println(answer);
    }
}
