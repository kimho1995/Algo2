package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2502 {

    static int day, cake;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        day = Integer.parseInt(st.nextToken());
        cake = Integer.parseInt(st.nextToken());
        A = new int[day];
        B = new int[day];
        A[0] = 1;
        B[1] = 1;
        for(int i=2; i<day; i++) {
            A[i] = A[i-1]+A[i-2];
            B[i] = B[i-1]+B[i-2];
        }
        int a = 1, b = 1;
        while(true) {
            if(A[day-1]*a + B[day-1]*b>cake) {
                a++;
                b=a;
                continue;
            }
            if(A[day-1]*a + B[day-1]*b==cake) break;
            b++;
        }
        System.out.println(a + "\n" + b);
        br.close();
    }

}