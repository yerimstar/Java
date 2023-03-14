import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int s1Len = s1.length();
        int s2Len = s2.length();
        int[][] dp = new int[s1Len+1][s2Len+1];

        for(int i = 1; i <= s1Len; i++){
            for(int j= 1; j <= s2Len; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        if(dp[s1Len][s2Len] == 0){
            System.out.println(0);
            return;
        }else{
            System.out.println(dp[s1Len][s2Len]);
        }

        StringBuilder sb = new StringBuilder();
        while(dp[s1Len][s2Len] != 0){
            if(dp[s1Len][s2Len] == dp[s1Len][s2Len-1]){
                s2Len--;
            }else if(dp[s1Len][s2Len]==dp[s1Len-1][s2Len]){
                s1Len--;
            }else if(dp[s1Len][s2Len]-1 == dp[s1Len-1][s2Len-1]){
                s1Len--;
                s2Len--;
                sb.insert(0,s1.charAt(s1Len));
            }
        }
        System.out.println(sb);

    }
}