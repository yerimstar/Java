import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
    static int n,m;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int x,y;
            int[][] arr = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }
            int cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] == 1){
                        if(dfs(arr,visited,i,j)){
                            cnt += 1;
                        }
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean dfs(int[][] arr,boolean[][] visited, int y, int x) {
        for(int i = 0; i < 4; i++){
            int dy = y + move[i][0];
            int dx = x + move[i][1];
            if(0 <= dy && dy < n && 0 <= dx  && dx < m){
                if(!visited[dy][dx] && arr[dy][dx] == 1) {
                    arr[dy][dx] = 0;
                    visited[dy][dx] = true;
                    dfs(arr, visited, dy, dx);
                }
            }
        }
        return true;
    }
}