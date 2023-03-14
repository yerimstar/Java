import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int s1Len = s1.length();
        int s2Len = s2.length();
        int[][] lcs = new int[s1Len+1][s2Len+1];
        for(int i = 1; i <= s1Len; i++){
            for(int j = 1; j <= s2Len; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        System.out.println(lcs[s1Len][s2Len]);
    }
}