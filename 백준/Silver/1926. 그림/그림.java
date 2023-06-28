import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] board;
    static boolean[][] visited;
    static int[][] mv = {{1,0},{-1,0},{0,1},{0,-1}};

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for(int i = 0;i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];
        int ans = 0;
        int cnt = 0;
        for(int i = 0;i < n; i++){
            for(int j = 0;j < m; j++){
                // 방문했거나, 색칠 안된 부분 넘어가기
                if(visited[i][j] || board[i][j] == 0)
                    continue;
                ans = Math.max(ans, bfs(i,j));
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(ans);
    }
    private static int bfs(int x, int y){
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(x,y));
        visited[x][y] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            Pos p = q.poll();
            cnt++;
            for(int i = 0;i < 4; i++){
                int dx = p.x + mv[i][0];
                int dy = p.y + mv[i][1];
                // 그림 범위 벗어난 경우 넘어가기
                if(dx < 0 || dx >= n || dy < 0 || dy >= m)
                    continue;
                // 방문했거나, 색칠 안된 부분 넘어가기
                if(visited[dx][dy] || board[dx][dy] == 0)
                    continue;
                // 방문처리
                visited[dx][dy] = true;
                // 큐에 삽입
                q.offer(new Pos(dx,dy));
            }
        }
        return cnt;
    }
}