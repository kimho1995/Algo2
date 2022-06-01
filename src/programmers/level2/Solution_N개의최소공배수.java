package programmers.level2;

import java.util.Arrays;

public class Solution_N개의최소공배수 {
    public int solution(int[] arr) {
        int lcm = arr[0];
        for(int i = 1; i < arr.length; i++) {
            lcm = lcm(arr[i], lcm);
        }
        return lcm;
    }

    public int lcm(int a, int b) {
        return a*b/gcd(a, b);
    }

    public int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        Solution_N개의최소공배수 sol = new Solution_N개의최소공배수();
        System.out.println(sol.solution(new int[]{3,4,9,16}));
    }
}
