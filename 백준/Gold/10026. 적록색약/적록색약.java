import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


public class Main {
    static class Pos{
        int x,y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static char[][] map;
    static boolean[][] visited;
    static int n,cnt;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n  = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for(int i = 0;i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = line.charAt(j);
            }
        }
        // 적록색약 아닌 사람들
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    bfs(i,j,map[i][j]);
                    cnt++;
                }
            }
        }
        sb.append(cnt).append(" ");
        // 적록색약인 사람들
        cnt = 0;
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    bfs(i,j,map[i][j]);
                    cnt++;
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }
    private static void bfs(int x, int y, char color){
        int[][] mv = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<Pos> q = new ArrayDeque<>();
        visited[x][y] = true;
        if (map[x][y] == 'G') {
            map[x][y] = 'R';
        }
        q.offer(new Pos(x,y));

        while(!q.isEmpty()){
            Pos cur = q.poll();
            for(int i = 0; i < 4; i++){
                int dx = cur.x + mv[i][0];
                int dy = cur.y + mv[i][1];
                if(dx < 0 || n <= dx || dy < 0 || n <= dy)
                    continue;
                if(!visited[dx][dy] && map[dx][dy] == color){
                    visited[dx][dy] = true;
                    if(map[dx][dy] == 'G'){ // 적록색약인 사람들 검사를 위해 G를 R과 동일하게 처리해두기
                        map[dx][dy] = 'R';
                    }
                    q.offer(new Pos(dx,dy));
                }
            }
        }
    }

}