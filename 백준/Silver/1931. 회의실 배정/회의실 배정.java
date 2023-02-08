import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] meeting = new int[n][2];
        int result = 0;
        int cnt = 0;
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(bf.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(meeting , ((o1, o2) -> {return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0]-o2[0];}));
        for(int[] m : meeting){
            if(m[0] >= result){
                cnt++;
                result = m[1];
            }
        }
        System.out.println(cnt);
    }
}