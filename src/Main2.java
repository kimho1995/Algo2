import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static final int MAX = 999999;
    static int N, init, answer;
    static int[] map, p;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        init = Integer.parseInt(str);
        N = str.length();
        map = new int[N];
        p = new int[N];
        v = new boolean[N];
        for(int i=0; i<N; i++) {
            map[i] = str.charAt(i)-'0';
        }
        answer = MAX;
        npr(0);
        System.out.println(answer==MAX? 0: answer);
    }

    static void npr(int cnt) {
        if (cnt == N) {
            sb.setLength(0);
            int num = sumNum();
            if(num>init) {
                answer = Math.min(answer, num);
            }
            return;
        }
        for(int i=0; i<N; i++) {
            if(!v[i]) {
                v[i] = true;
                p[cnt] = map[i];
                npr(cnt+1);
                v[i] = false;
            }
        }
    }

    static int sumNum() {
        for(int i=0; i<N; i++) {
            sb.append(p[i]);
        }
        return Integer.parseInt(sb.toString());
    }
}
