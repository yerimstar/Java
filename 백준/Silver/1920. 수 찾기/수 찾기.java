import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] a;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        a = new int[n];
        st = new StringTokenizer(bf.readLine()," ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a); // 정렬

        m = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine()," ");
        for (int i = 0; i < m; i++) {
            sb.append(binarySearch(a,Integer.parseInt(st.nextToken())) + "\n");
        }
        System.out.println(sb.toString());

    }
    public static int binarySearch(int[] a,int key){
        int result = 0;
        if(Arrays.binarySearch(a,key) >= 0) {
            result = 1;
        }
        return result;
    }
}