import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int k, n;
    static int[] lan;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine(), " ");
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        long lo = 0;
        long hi = 0;
        long mid;
        lan = new int[k];
        for (int i = 0; i < k; i++) {
            int l = Integer.parseInt(bf.readLine());
            if (l > hi)
                hi = l;
            lan[i] = l;
        }
        hi++; // mid값 0 방지 
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (upperBound(mid) < n) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        sb.append(lo - 1);
        System.out.println(sb.toString());
    }

    private static long upperBound(long mid) {
        long cnt = 0;
        for (int l : lan) {
            cnt += (l / mid);
        }
        return cnt;
    }
}