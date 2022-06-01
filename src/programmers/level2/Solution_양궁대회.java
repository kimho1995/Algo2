package programmers.level2;

import java.util.Arrays;

public class Solution_양궁대회 {
    static int max;
    static int[] need, answer, v;
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        need = new int[11];
        v = new int[11];
        for(int i=0; i< info.length; i++) {
            need[i] = info[i]+1;
        }
        need[10] = 0;

        search(0, n);

        if(max==0) return new int[]{-1};
        return answer;
    }

    static void search(int start, int arrow) {
        //화살 다 쏜경우
        if(arrow<=0) {
            int num = calc();
            check(num);
            return;
        }
        // 화살 남은 경우
        if(start == need.length) {
            int num = calc();
            v[10] += arrow;
            check(num);
            v[10] = 0;
            return;
        }
        for(int i=start; i<need.length; i++) {
            arrow -= need[i];
            v[i] = arrow<0?need[i]+arrow:need[i];
            search(i+1, arrow);
            arrow += need[i];
            v[i] = 0;
        }
    }

    static int calc() {
        int sumA = 0;
        int sumB = 0;
        for(int i=0; i<v.length; i++) {
            if(v[i]==need[i]) {
                sumA += 10-i;
            } else if(need[i]>1) {
                sumB += 10-i;
            }
        }
        return sumA-sumB;
    }

    static void check(int num) {
        if(max < num) {
            max = num;
            copy();
            return;
        } else if(max == num) {
            for(int i=10; i>=0; i--) {
                if(answer[i] != v[i]) {
                    if(answer[i] < v[i]) {
                        copy();
                    }
                    return;
                }
            }
        }
    }

    static void copy() {
        for(int i=0; i<answer.length; i++) {
            answer[i] = v[i];
        }
    }

    public static void main(String[] args) {
        Solution_양궁대회 sol = new Solution_양궁대회();
        System.out.println(Arrays.toString(sol.solution(3, new int[]{0,0,1,0,0,0,0,0,0,1,0})));
    }
}
