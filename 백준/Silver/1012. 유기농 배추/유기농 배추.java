import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 1로 이어진 영역이 몇개인지 찾는 문제
public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] mv = {{1,0},{0,1},{-1,0},{0,-1}};
    static class Pos{
        private int x;
        private int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            for(int i = 0;i < k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            int cnt = 0;
            for(int i = 0;i < n; i++){
                for(int j = 0;j < m; j++){
                    if(visited[i][j] || map[i][j] == 0)
                        continue;
                    bfs(i,j);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    private static void bfs(int x, int y){
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(x,y));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Pos p = q.poll();
            for(int i = 0;i < 4; i++){
                int dx = p.x + mv[i][0];
                int dy = p.y + mv[i][1];
                if(dx < 0 || dx >= n || dy < 0 || dy >= m)
                    continue;
                if(visited[dx][dy] || map[dx][dy] == 0)
                    continue;
                visited[dx][dy] = true;
                q.offer(new Pos(dx,dy));
            }
        }
    }
}