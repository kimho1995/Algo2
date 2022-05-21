package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main_5430 {

    static int T;
    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            System.out.println(start(p,n,arr));
        }

        br.close();
    }

    static String start(String p, int n, String arr) {
        deque = new LinkedList<>();
        boolean isBack = false;
        if(n!=0) {
            String[] strArr = arr.substring(1, arr.length() - 1).split(",");
            for (int i = 0; i < strArr.length; i++) {
                deque.offerLast(Integer.parseInt(strArr[i]));
            }
        }
        for(int i=0; i<p.length(); i++) {
            char c = p.charAt(i);
            if(c == 'R') {
                isBack = !isBack;
            } else {
                if(deque.isEmpty()) return "error";
                if(isBack) {
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(!deque.isEmpty()) {
            int a = 0;
            if(isBack) {
                a = deque.pollLast();
            } else {
                a = deque.pollFirst();
            }
            sb.append(a+",");
        }
        if(sb.length()>1)
            sb.setLength(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

}