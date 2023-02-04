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
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬
        Arrays.sort(arr);
        // 이분탐색 - upperBound
        int lo = 0;
        int hi = arr[n-1];
        int mid;
        while(lo < hi){
            mid = (lo+hi)/2;
            if(upperBound(mid) < m){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        System.out.println(lo-1);
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