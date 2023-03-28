import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(i == 0) {
				dp[i][0] = Integer.parseInt(st.nextToken());
				dp[i][1] = Integer.parseInt(st.nextToken());
				dp[i][2] = Integer.parseInt(st.nextToken());
			}else {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + Integer.parseInt(st.nextToken());
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + Integer.parseInt(st.nextToken());
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]),dp[n-1][2]));
	}
}