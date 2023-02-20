import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] lan;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        long n = Integer.parseInt(st.nextToken());
        long s = 0, e= 0, mid = 0;
        lan = new int[k];
        for(int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());
            lan[i] = num;
            e = Math.max(num, e);
        }
        e++;
        while(s < e) {
            mid = (s+e)/2;
            if(check(mid) < n) {
                e = mid;
            }else {
                s = mid + 1;
            }
        }
        System.out.println(s-1);
    }
    public static long check(long mid) {
        long cnt = 0;
        for(int i = 0; i < k; i++) {
            cnt += (lan[i]/mid);
        }
        return cnt;
    }
}