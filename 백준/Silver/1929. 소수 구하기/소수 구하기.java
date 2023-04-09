import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        nums = new int[n+1];
        prime(m,n);
        StringBuilder sb = new StringBuilder();
        for(int i = m; i < n+1; i++){
            if(nums[i] != 0)
                sb.append(nums[i]).append("\n");
        }
        System.out.println(sb);
    }
    private static void prime(int m,int n){
        for(int i = 2; i < n+1; i++){
            nums[i] = i;
        }
        for(int i = 2; i < n+1; i++){
            if(nums[i] == 0)
                continue;
            for(int j = i+i; j < n+1; j+=i){
                nums[j] = 0;
            }
        }
    }
}