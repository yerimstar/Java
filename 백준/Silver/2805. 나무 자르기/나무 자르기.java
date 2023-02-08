import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        // 입력
        st = new StringTokenizer(bf.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(bf.readLine()," ");

        int lo = 0;
        int hi = 0;
        int mid;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > hi) // 최댓값 구하기
                hi = arr[i];
        }
        // 이분탐색 - upperBound
        while(lo < hi){
            mid = (lo+hi)/2;
            if(upperBound(mid) < m){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        sb.append(lo-1);
        System.out.println(sb.toString());
    }
    private static long upperBound(int l){
        long result = 0;
        for(int a: arr){
            if(a > l)
                result += (a-l);
        }
        return result;
    }
}