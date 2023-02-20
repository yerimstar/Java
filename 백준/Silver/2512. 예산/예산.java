import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] money = new int[n];
        int s = 1, e = 0, mid = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n; i++){
            money[i] = Integer.parseInt(st.nextToken());
            e = Math.max(e,money[i]);
        }
        int m = Integer.parseInt(br.readLine());
        e++;
        while (s < e) {
            mid = (s+e)/2;
            int sum = 0;
            for(int i = 0; i < n; i++){
                if(mid >= money[i])
                    sum += money[i];
                else
                    sum += mid;
            }
            if(sum <= m)
                s = mid + 1;
            else
                e = mid;
        }
        System.out.println(s-1);
    }
}