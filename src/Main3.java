import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    static int N;
    static int[] dp;
    static int[] money = {5,2,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        System.out.println(start());
    }

    static int start() {
        if(N==0) return 0;
        if(N==1||N==2||N==5||N==7) return 1;
        if(N==3||N==4||N==6) return 2;
        dp[1]=dp[2]=dp[5]=dp[7]=1;
        dp[3]=dp[4]=dp[6]=2;
        for(int i=8; i<=N; i++) {
            dp[i] = dp[i-7]+1;
            for(int m : money) {
                dp[i] = Math.min(dp[i], dp[i-m]+1);
            }
        }
        return dp[N];
    }
}
