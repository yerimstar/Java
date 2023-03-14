import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] lst = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            lst[i] = Integer.parseInt(st.nextToken());
        }
        int ans = Integer.MIN_VALUE;
        int tmp = 0;
        for(int i = 0;i < k; i++){
            tmp += lst[i];
        }
        ans = Math.max(ans,tmp);
        for(int i = 1; i < n-k+1; i++){
            tmp = tmp + lst[i+k-1]-lst[i-1];
            ans = Math.max(ans,tmp);
        }
        System.out.println(ans);
    }
}