package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504 {

    static Stack<String> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        stack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c=='(' || c=='[') stack.push(c+"");
            else {
                check(c);
            }
        }
        int answer = 0;
        while(!stack.isEmpty()) {
            String c = stack.pop();
            if(c.equals("(") || c.equals("[")) {
                System.out.println(0);
                System.exit(0);
            }
            answer += Integer.parseInt(c);
        }
        System.out.println(answer);
        br.close();
    }

    static void check(char c){
        int sum = 0;
        while(true) {
            if(stack.isEmpty()) {
                System.out.println(0);
                System.exit(0);
            }
            String str = stack.pop();
            if(c == ')') {
                if(str.equals("(")) {
                    if(sum == 0) stack.push("2");
                    else stack.push((2*sum)+"");
                    break;
                } else if(str.equals("[")) {
                    System.out.println(0);
                    System.exit(0);
                }
            } else if(c == ']') {
                if(str.equals("[")) {
                    if(sum == 0) stack.push("3");
                    else stack.push((3*sum)+"");
                    break;
                } else if(str.equals("(")) {
                    System.out.println(0);
                    System.exit(0);
                }
            }
            sum += Integer.parseInt(str);
        }

    }

}