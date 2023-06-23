import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] mv = {{0,1},{1,0},{0,-1},{-1,0}};

    static class Pos{
        private int x;
        private int y;
        private int cnt;
        private boolean crush;

        public Pos(int x, int y,int cnt, boolean crush){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.crush = crush;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][2];
        for(int i = 0;i < n; i++){
            String s = br.readLine();
            for(int j = 0;j < m; j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }
        int ans = bfs(0,0);
        System.out.println(ans);
    }
    private static int bfs(int x,int y){
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(x,y,1,false));
        visited[x][y][0] = true;
        while(!q.isEmpty()){
            Pos cur = q.poll();
            if(cur.x == n-1 && cur.y == m-1){
                return cur.cnt;
            }
            for(int i = 0;i < 4; i++){
                int dx = cur.x + mv[i][0];
                int dy = cur.y + mv[i][1];
                int cnt = cur.cnt + 1;
                if (dx < 0 || dx >= n || dy < 0 || dy >= m) {
                    continue;
                }
                // 벽이 아니면
                if(map[dx][dy] == 0){
                    if(!cur.crush && !visited[dx][dy][0]){
                        q.offer(new Pos(dx,dy,cnt,false));
                        visited[dx][dy][0] = true;
                    }else if(cur.crush && !visited[dx][dy][1]){
                        q.offer(new Pos(dx,dy,cnt,true));
                        visited[dx][dy][1] = true;
                    }
                }
                // 벽이면
                else if(map[dx][dy] == 1){
                    // 벽을 부수고 큐 삽입
                    if(!cur.crush && !visited[dx][dy][1]){
                        q.offer(new Pos(dx,dy,cnt,true));
                        visited[dx][dy][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}