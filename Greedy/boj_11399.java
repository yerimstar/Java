import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] times = new int[n];
        for(int i = 0; i < n;i++)
            times[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(times);
        int resultTime = 0;
        for(int i = 0; i < n; i++){
            resultTime += times[i]*(n-i);
        }
        System.out.println(resultTime);
    }
}
