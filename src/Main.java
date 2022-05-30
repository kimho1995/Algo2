import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr, copy;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        copy = new int[N];
        set = new HashSet<>();
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        Arrays.sort(arr);

        for(int i=0; i<N; i++) {
            int add = arr[i];
            int idx = 0;
            Iterator<Integer> iter = set.iterator();
            while(iter.hasNext()) {
                copy[idx++] = iter.next()+add;
            }
            for(int j=0; j<N; j++) {
                set.add(copy[j]);
            }
        }

    }
}
