import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 입력
        int n = Integer.parseInt(bf.readLine());
        int[] T = new int[n];
        int[] P = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        // dp
        int[] dp = new int[n + 1];
        for(int i = 0; i < n; i++){
            if(i+T[i] < n+1)
                dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]);
            dp[i+1] = Math.max(dp[i+1],dp[i]);
        }

        System.out.println(dp[n]);
    }
}