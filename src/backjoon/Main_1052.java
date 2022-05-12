package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1052 {

    static int N, K, bottle, answer;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int size = setting();
        int cnt = 0;
        if(bottle > K) {
            if (list[0] == 0) {
                answer += (Math.pow(2, 0) * 2);
            } else {
                answer += (Math.pow(2, 0));
                cnt++;
            }
            list[1]++;
            for (int i = 1; i < size; i++) {
                if (K == bottle) break;
                if (list[i] == 1) {
                    answer += (Math.pow(2, i));
                } else {
                    cnt++;
                    if (cnt > 1) bottle--;
                }
                list[i + 1]++;
            }
        }
        System.out.println(answer);

        br.close();
    }

    static int setting() {
        list = new int[100];
        int num = N;
        int rest = 0;
        int idx = 0;
        while(num > 0) {
            rest = num%2;
            list[idx++] = rest;
            if(rest == 1) bottle++;
            num /= 2;
        }
        return idx;
    }
}