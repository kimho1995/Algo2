package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_11478 {
    static int answer;
    static String str;
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        for(int i=0; i<str.length(); i++) {
            map = new HashMap<>();
            for(int j=0; j<str.length()-i; j++) {
                map.put(str.substring(j,j+i+1), 0);
            }
            answer += map.size();
        }
        System.out.println(answer);
    }
}
