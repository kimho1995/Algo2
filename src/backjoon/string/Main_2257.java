package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2257 {
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        stack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c==')') {
                int sum = 0;
                while(true) {
                    int s = stack.pop();
                    if(s == -1) break;
                    sum += s;
                }
                stack.push(sum);
                continue;
            }
            if(2<=c-'0' && c-'0'<=9) {
                int s = stack.pop();
                stack.push(s*(c-'0'));
                continue;
            }
            if(c=='(') {
                stack.push(-1);
                continue;
            }
            if(c=='C') {
                stack.push(12);
                continue;
            }
            if(c=='H') {
                stack.push(1);
                continue;
            }
            if(c=='O') {
                stack.push(16);
                continue;
            }
        }
        int answer = 0;
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}
