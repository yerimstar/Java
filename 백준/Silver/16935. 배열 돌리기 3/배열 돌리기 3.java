import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n,m, arrSize,tmpNum;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arrSize = Math.max(n,m);
        arr = new int[arrSize+1][arrSize+1];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < r; i++) {
            int num = Integer.parseInt(st.nextToken());
            switch(num) {
                case 1:
                    change1();
                    break;
                case 2:
                    change2();
                    break;
                case 3:
                    change3();
                    tmpNum = n;
                    n = m;
                    m = tmpNum;
                    break;
                case 4:
                    change4();
                    tmpNum = n;
                    n = m;
                    m = tmpNum;
                    break;
                case 5:
                    change5();
                    break;
                case 6:
                    change6();
                    break;
            }
        }
        for(int i = 0; i < n;i++) {
            for(int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    private static void change1() {
        for(int i = 0; i < n/2; i++) {
            for(int j = 0; j < m; j++) {
				arr[n][j] = arr[i][j];
				arr[i][j] = arr[n-i-1][j];
				arr[n-i-1][j] = arr[n][j];
            }
        }
    }
    private static void change2(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m/2; j++){
                arr[i][m] = arr[i][j];
                arr[i][j] = arr[i][m-j-1];
                arr[i][m-j-1] = arr[i][m];
            }
        }
    }

    private static void change3() {
        int[][] tmp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                tmp[i][j] = arr[n-j-1][i];
            }
        }
        for(int i = 0; i < m; i++){
            for(int j= 0; j < n; j++){
                arr[i][j] = tmp[i][j];
            }
        }
    }

    private static void change4() {
        int[][] tmp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                tmp[i][j] = arr[j][m-i-1];
            }
        }
        for(int i = 0; i < m; i++){
            for(int j= 0; j < n; j++){
                arr[i][j] = tmp[i][j];
            }
        }
    }
    private static void change5(){
        int[][] tmp2 = new int[n/2][m/2];
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < m/2;j++){
                tmp2[i][j] = arr[i][j]; // 1 -> tmp
                arr[i][j] = arr[n/2+i][j]; // 4 -> 1
                arr[n/2+i][j] = arr[n/2+i][m/2+j]; // 3 -> 4
                arr[n/2+i][m/2+j] = arr[i][m/2+j]; // 2 -> 3
                arr[i][m/2+j] = tmp2[i][j]; // tmp(1) -> 2
            }
        }
    }
    private static void change6(){
        int[][] tmp2 = new int[n/2][m/2];
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < m/2;j++){
                tmp2[i][j] = arr[i][j]; // 1 -> tmp(1)
                arr[i][j] = arr[i][m/2+j]; // 2 -> 1
                arr[i][m/2+j] = arr[n/2+i][m/2+j]; // 3 -> 2
                arr[n/2+i][m/2+j] = arr[n/2+i][j]; // 4 -> 3
                arr[n/2+i][j] = tmp2[i][j]; // tmp(1) -> 4
            }
        }
    }
}