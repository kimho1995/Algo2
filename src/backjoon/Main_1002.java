package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1002 {

    static int T;
    static double distSum, distSub, circleDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int arr[] = new int[6];
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<6; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            distSum = arr[2] + arr[5];
            distSub = Math.abs(arr[2] - arr[5]);
            circleDist = calc(arr);
            if(circleDist == 0) {
                if(arr[2] != arr[5]) System.out.println(0);
                else System.out.println(-1);
            } else if(distSum > circleDist) {
                if(distSub == circleDist) System.out.println(1);
                else if(distSub > circleDist) System.out.println(0);
                else System.out.println(2);
            } else if(distSum < circleDist) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }


        br.close();
    }

    static double calc(int [] arr){
        return Math.sqrt((arr[0]-arr[3])*(arr[0]-arr[3]) + (arr[1]-arr[4])*(arr[1]-arr[4]));
    }
}