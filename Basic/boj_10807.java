import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int cnt = 0;

        int[] nums = new int[N];
        int v;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        v = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            if (nums[i] == v)
                cnt += 1;
        }
        System.out.print(cnt);
    }
}
