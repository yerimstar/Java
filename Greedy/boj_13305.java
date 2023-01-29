import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 범위를 잘 확인할 것 !
public class boj_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        long[] roads = new long[n - 1];
        long[] prices = new long[n];

        // 도로, 주유 가격 입력
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n - 1; i++) {
            roads[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        // 가격 계산
        long minPrice = prices[0];
        long resultPrice = minPrice * roads[0];
        for (int i = 1; i < n - 1; i++) {
            if (minPrice > prices[i])
                minPrice = prices[i];
            resultPrice += minPrice * roads[i];
        }
        System.out.println(resultPrice);
    }
}
