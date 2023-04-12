import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n ,m,k,cnt;
    static int[][] map;
    static int[] mx = {1,-1,0,0};
    static int[] my = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0;i < k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r-1][c-1] = 1;
        }

        int result = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0; j < m; j++){
                cnt = 0;
                if(map[i][j] ==1){
                    dfs(i,j);
                }
                result = Math.max(result,cnt);
            }
        }
        System.out.println(result);
    }
    private static void dfs(int x, int y){
        cnt++;
        map[x][y] = 0;
        for(int i = 0;i < 4; i++){
            int dx = x + mx[i];
            int dy = y + my[i];
            if(dx < 0 || dx >= n || dy < 0 || dy >= m)
                continue;
            if(map[dx][dy] == 1){
                dfs(dx,dy);
            }
        }
    }
}