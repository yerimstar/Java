import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] operator;
    static int min_val = Integer.MAX_VALUE;
    static int max_val = Integer.MIN_VALUE;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0;i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        operator = new int[4];
        for(int i = 0;i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        backtrack(arr[0],1);
        System.out.println(max_val);
        System.out.println(min_val);
    }
    private static void backtrack(int sum, int cur){
        if(cur == n){
            min_val = Math.min(min_val, sum);
            max_val = Math.max(max_val,sum);
            return;
        }
        for(int i = 0; i  < 4; i++){
            if(operator[i] > 0){
                operator[i]--;
                switch (i){
                    case 0:
                        backtrack(sum + arr[cur], cur+1);
                        break;
                    case 1:
                        backtrack(sum - arr[cur], cur+1);
                        break;
                    case 2:
                        backtrack(sum * arr[cur], cur+1);
                        break;
                    case 3:
                        backtrack(sum / arr[cur], cur+1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}