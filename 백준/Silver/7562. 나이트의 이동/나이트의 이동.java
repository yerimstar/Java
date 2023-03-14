import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos{
        int x,y,cnt;
        public Pos(int x, int y,int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int l,sx,sy,ex,ey;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());
            sb.append(bfs(sx,sy,ex,ey)).append("\n");
        }
        System.out.println(sb);
    }
    private static int bfs(int sx,int sy,int ex,int ey){
        boolean[][] visited = new boolean[l][l];
        int[][] mv = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,-2},{2,-1},{2,1},{1,2}};
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(sx,sy,0));
        visited[sx][sy] = true;

        int cnt = 0;
        while(!q.isEmpty()){
            Pos cur = q.poll();
            if(cur.x == ex && cur.y == ey){
                cnt = cur.cnt;
            }
            for(int i = 0;i < 8; i++){
                int dx = cur.x + mv[i][0];
                int dy = cur.y + mv[i][1];
                if(dx < 0 || dx >= l || dy < 0 || dy >= l)
                    continue;
                if(!visited[dx][dy]){
                    visited[dx][dy] = true;
                    q.offer(new Pos(dx,dy,cur.cnt+1));
                }
            }
        }
        return cnt;
    }
}