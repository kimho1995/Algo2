package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1062 {

    static int N, K, totalLen, answer;
    static ArrayList<Map<Character, Integer>> word;
    static Character[] common = {'a', 'n', 't', 'i', 'c'};
    static Map<Character, Integer> total;
    static ArrayList<Character> p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        word = new ArrayList<>();
        totalLen = K-5;
        answer = 0;
        total = new HashMap<>();
        p = new ArrayList<>();
        if(totalLen < 0) System.out.println(answer);
        else {
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                int len = str.length();
                if(len==8) answer++;
                else {
                    Map<Character, Integer> map = new HashMap<>();
                    for(int j=0; j<len-8; j++) {
                        map.put(str.charAt(4+j), 0);
                    }
                    for(int j=0; j< common.length; j++) {
                        map.remove(common[j]);
                    }
                    if(map.size()==0) answer++;
                    else if(map.size()<=totalLen) {
                        total.putAll(map);
                        word.add(new HashMap<>(map));
                    }
                }
            }
            Set<Character> it = total.keySet();
            for(char c : it) {
                p.add(c);
            }
            if(p.size() < totalLen) totalLen = p.size();
            nCr(0, 0, new char[totalLen], answer);
            System.out.println(answer);
        }
        br.close();
    }

    static void nCr(int cnt, int start, char[] n, int add) {
        if(cnt == totalLen) {
            int ck = 0;
            int count = 0;
            for(int i=0; i<word.size(); i++) {
                Map<Character, Integer> map = word.get(i);
                for(int j=0; j<cnt; j++) {
                    if(map.containsKey(n[j])) {
                        ck++;
                    }
                }
                if(ck==map.size()) {
                    count++;
                }
                ck = 0;
            }
            answer = Math.max(answer, count+add);
            return;
        }
        for(int i=start; i<p.size(); i++) {
            n[cnt] = p.get(i);
            nCr(cnt+1,i+1,n, add);
        }
    }
}

/*
import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int k;
    public static int[] words;
    public static int[] a = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        words = new int[n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (char c : str.toCharArray()) {
                words[i] |= (1 << (c - 'a'));
            }
        }

        if (k < 5) {
            bw.write("0\n");
            bw.flush();
            System.exit(0);
        }

        bw.write(go(0, 0, 0) + "\n");
        bw.flush();
    }

    public static int check(int mask) {
        int count = 0;
        for (int word : words) {
            int tmp = word & mask;
            if(tmp == word) count++;
        }

        return count;
    }
    public static int go(int idx, int count, int mask) {
        if (count > k - 5) return 0;
        if (idx == 26) return count == k - 5 ? check(mask) : 0;


        if (idx == 'a' - 'a' || idx == 'n' - 'a' || idx == 't' - 'a' || idx == 'c' - 'a' || idx == 'i' - 'a') return go(idx + 1, count, mask | (1 << idx));

        a[idx] = 1;
        int result = go(idx + 1, count + 1, mask | (1 << idx));
        a[idx] = 0;
        int tmp = go(idx + 1, count, mask);
        if(tmp > result) result = tmp;

        return result;
    }
}
 */

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static String[] words;
    static boolean[] alphabet; // 읽을 수 있는 문자인지 판별하는 배열
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        words = new String[n];
        alphabet = new boolean[26];
        for(int i = 0; i < n; i++)
            words[i] = br.readLine();

        alphabet['a' - 'a'] = true;
        alphabet['n' - 'a'] = true;
        alphabet['t' - 'a'] = true;
        alphabet['i' - 'a'] = true;
        alphabet['c' - 'a'] = true;

        if(k < 5)
            result = 0;
        else {
            // 'anta', 'tica'에서 사용되는 문자 5개를 제외한 나머지 갯수만큼 문자의 조합을 구성해야 하므로 5를 빼준다.
            k -= 5;
            dfs(0, 0);
        }

        System.out.println(result);
    }

    // (k-5)개만큼의 문자 조합 뽑아내기
    public static void dfs(int idx, int cnt) {
        if(cnt == k) {
            // 조합 뽑았으면 읽을 수 있는 최대 단어 수 업데이트
            result = Math.max(result, readPossibleCnt());
            return;
        }

        for(int i = idx; i < 26; i++) {
            if(alphabet[i])
                continue;

            alphabet[i] = true;
            dfs(i, cnt + 1);
            alphabet[i] = false;
        }
    }

    // (k-5)개의 문자를 조합으로 뽑아서 읽을 수 있는 문자로 판단했을 때, 읽을 수 있는 단어의 수 구하기
    public static int readPossibleCnt() {
        int cnt = 0;
        boolean flag = true;

        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            flag = true;
            for(int j = 0; j < s.length(); j++) {
                if(! alphabet[s.charAt(j) - 'a']) {
                    flag = false;
                    break;
                }
            }

            if(flag)
                cnt++;
        }

        return cnt;
    }
}
 */