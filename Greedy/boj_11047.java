import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int tmp;
        int cnt = 0;
        Integer[] coins = new Integer[n];
        for(int i =0; i < n;i++){
            coins[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(coins, Comparator.reverseOrder());
        for(int coin : coins){
            if(k >= coin){
                tmp = k/coin;
                k -= tmp * coin;
                cnt += tmp;
            }
        }
        System.out.println(cnt);
    }
}
