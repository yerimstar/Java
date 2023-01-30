import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int cnt = 0;
        while (n > 0) {
            if (n == 1) {
                cnt = -1;
                break;
            }
            if (n % 5 == 0) {
                cnt += n / 5;
                break;
            }
            n -= 2;
            cnt++;
        }
        System.out.println(cnt);

    }
}
