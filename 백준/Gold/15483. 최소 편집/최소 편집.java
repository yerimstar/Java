import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int str1Len = str1.length();
		int str2Len = str2.length();
		int[][] dp = new int[str1Len + 1][str2Len + 1];
		for(int i = 1; i < str1Len+1; i++) {
			dp[i][0] = dp[i-1][0] + 1;
		}
		for(int j = 1; j < str2Len+1; j++) {
			dp[0][j] = dp[0][j-1]+1;
		}
		for (int i = 1; i < str1Len+1; i++) {
			for (int j = 1; j < str2Len+1; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
					
				}
			
			}
		}
		System.out.println(dp[str1Len][str2Len]);
	}
}