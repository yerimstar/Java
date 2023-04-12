import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n ,m,k,cnt;
    static int[][] map;
    static int[] mx = {1,-1,0,0};
    static int[] my = {0,0,1,-1};
    static class Pos{
        int x;
        int y;
        Pos(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
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
                    bfs(i,j);
                }
                result = Math.max(result,cnt);
            }
        }
        System.out.println(result);
    }
    private static void bfs(int x, int y){
        Queue<Pos> q = new ArrayDeque<Pos>();
        q.offer(new Pos(x,y));
        while(!q.isEmpty()){
            Pos cur = q.poll();
            for(int i = 0;i < 4; i++){
                int dx = cur.x + mx[i];
                int dy = cur.y + my[i];
                if(dx < 0 || dx >= n || dy < 0 || dy >= m)
                    continue;
                if (map[dx][dy] == 1) {
                    cnt++;
                    map[dx][dy] = 0;
                    q.offer(new Pos(dx,dy));
                }
            }
        }
    }
}