import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int whiteCnt, blueCnt;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int sum = 0;
        for(int i = 0;i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j < n ;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }
        dfs(0,0,n);
        sb.append(whiteCnt).append("\n").append(blueCnt);
        System.out.println(sb);
    }
    private static void dfs(int x, int y, int size){
        int num = check(x,y,size);
        if(num == 0){
            whiteCnt += 1;
            return;
        }else if(num == size*size){
            blueCnt += 1;
            return;
        }else{
            int half = size/2;
            dfs(x,y,half);
            dfs(x,y+half,half);
            dfs(x+half,y,half);
            dfs(x+half,y+half,half);
        }

    }
    private static int check(int x, int y, int size){
        int sum = 0;
        for(int i = 0; i < size; i++){
            for(int j =0; j < size; j++){
                sum += map[x+i][y+j];
            }
        }
        return sum;
    }
}