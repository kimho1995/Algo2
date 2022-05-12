package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7568 {

    static int T;
    static int[][] person;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        person = new int[T][T];
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            person[i][0] = Integer.parseInt(st.nextToken());
            person[i][1] = Integer.parseInt(st.nextToken());
        }

        calc();

        br.close();
    }

    static void calc(){
        for(int i=0; i<T; i++) {
            int rank = 1;
            for(int j=0; j<T; j++) {
                if(i==j) continue;
                if(person[i][0] < person[j][0] && person[i][1] < person[j][1]) rank++;
            }
            System.out.print(rank + " ");
        }
    }
}