import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
최소한의 연산으로 정수 n -> 1 만들기
=> 1 -> n을 만드는 것으로 바꿔서 생각함
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        for(int i = 2; i < n+1; i++){
            // 1을 더한다.
            dp[i] = dp[i-1] + 1;
            // 2로 나누어 떨어지는 경우
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
            // 3으로 나누어 떨어지는 경우
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }
        }
        System.out.println(dp[n]);
    }
}