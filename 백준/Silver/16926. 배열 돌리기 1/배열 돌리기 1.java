import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int cnt = 0;

        cnt = Math.min(n, m) / 2;
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < cnt; j++){
                int tmp = arr[j][j]; // 시작 값 저장
                // 위
                for (int k = j+1; k < m - j; k++) {
                    arr[j][k-1] = arr[j][k];
                }
                // 오른쪽
                for(int k = j+1; k < n-j; k++){
                    arr[k-1][m-j-1] = arr[k][m-j-1];
                }
                // 아래
                for(int k = m-j-1; k > j; k--){
                    arr[n-j-1][k] = arr[n-j-1][k-1];
                }
                // 왼쪽
                for(int k = n-j-1; k > j; k--){
                    arr[k][j] = arr[k-1][j];
                }
                arr[j+1][j] = tmp;

            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}