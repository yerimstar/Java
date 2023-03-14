import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0;i < T; i++){
            int n = Integer.parseInt(br.readLine());

            if(n == 0){
                sb.append("1").append(" ").append("0").append("\n");
            } else {
                fibonacci(n);
                sb.append(dp[n - 1]).append(" ").append(dp[n]).append("\n");
            }
        }
        System.out.println(sb);
    }
    private static void fibonacci(int n){
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        if(n > 1){
            for(int i = 2; i < n+1; i++){
                dp[i] = dp[i-2] + dp[i-1];
            }
        }
    }
}